import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        manager.addStudent();
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        manager.searchStudent();
                        break;

                    case 4:
                        manager.updateStudent();
                        break;

                    case 5:
                        manager.deleteStudent();
                        break;

                    case 6:
                        System.out.println("Thank you for using Student Management System.");
                        break;

                    default:
                        System.out.println("Please select a valid option.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                choice = 0;
            }

        } while (choice != 6);

        scanner.close();
    }
}