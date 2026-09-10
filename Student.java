public class Student extends Person {

    private int studentId;
    private String course;
    private double marks;

    static int studentCount = 0;

    public Student(int studentId, String name, String course, int age, double marks) {
        super(name, age);
        this.studentId = studentId;
        this.course = course;
        this.marks = marks;
        studentCount++;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public void displayBasicInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
    }

    @Override
    public String toString() {
        return studentId + "," + name + "," + course + "," + age + "," + marks;
    }
}