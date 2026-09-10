import java.io.*;
import java.util.*;

public class StudentManager implements Manageable {

    ArrayList<Student> students = new ArrayList<>();
    HashMap<Integer, Student> studentMap = new HashMap<>();
    HashSet<String> courses = new HashSet<>();

    Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        loadStudents();
    }

    @Override
    public void addStudent() {

        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            if (studentMap.containsKey(id)) {
                System.out.println("Student ID already exists.");
                return;
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Marks: ");
            double marks = Double.parseDouble(scanner.nextLine());

            if (age <= 0 || marks < 0 || marks > 100) {
                System.out.println("Please enter valid age and marks.");
                return;
            }

            Student student = new Student(id, name, course, age, marks);

            students.add(student);
            studentMap.put(id, student);
            courses.add(course);

            saveStudents();

            System.out.println("Student added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        }
    }

    @Override
    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n===== Student Records =====");

        for (Student student : students) {
            student.displayBasicInfo();
            System.out.println("---------------------------");
        }
    }

    @Override
    public void searchStudent() {

        try {
            System.out.print("Enter Student ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());

            Student student = studentMap.get(id);

            if (student != null) {
                System.out.println("\n===== Student Found =====");
                student.displayBasicInfo();
            } else {
                System.out.println("Student not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid Student ID.");
        }
    }

    @Override
    public void updateStudent() {

        try {
            System.out.print("Enter Student ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            Student student = studentMap.get(id);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter New Course: ");
            String course = scanner.nextLine();

            System.out.print("Enter New Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Marks: ");
            double marks = Double.parseDouble(scanner.nextLine());

            if (age <= 0 || marks < 0 || marks > 100) {
                System.out.println("Please enter valid age and marks.");
                return;
            }

            student.setName(name);
            student.setCourse(course);
            student.setAge(age);
            student.setMarks(marks);

            courses.add(course);

            saveStudents();

            System.out.println("Student updated successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid input.");
        }
    }

    @Override
    public void deleteStudent() {

        try {
            System.out.print("Enter Student ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Student student = studentMap.get(id);

            if (student == null) {
                System.out.println("Student not found.");
                return;
            }

            students.remove(student);
            studentMap.remove(id);

            saveStudents();

            System.out.println("Student deleted successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid Student ID.");
        }
    }

    public void saveStudents() {

        try {
            FileWriter writer = new FileWriter("students.txt");

            for (Student student : students) {
                writer.write(student.toString());
                writer.write("\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving student records.");
        }
    }

    public void loadStudents() {

        File file = new File("students.txt");

        if (!file.exists()) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String course = data[2];
                    int age = Integer.parseInt(data[3]);
                    double marks = Double.parseDouble(data[4]);

                    Student student = new Student(id, name, course, age, marks);

                    students.add(student);
                    studentMap.put(id, student);
                    courses.add(course);
                }
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading student records.");
        }
    }
}