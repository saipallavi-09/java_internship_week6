import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BackupThread extends Thread {

    @Override
    public void run() {

        try {

            FileInputStream input = new FileInputStream("students.txt");
            FileOutputStream output = new FileOutputStream("students_backup.txt");

            int data;

            while ((data = input.read()) != -1) {
                output.write(data);
            }

            input.close();
            output.close();

            System.out.println("Backup completed successfully.");

        } catch (IOException e) {
            System.out.println("Backup could not be completed.");
        }
    }
}