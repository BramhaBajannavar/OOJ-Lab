
import CIE.*;
import SEE.*;
import java.util.Scanner;

public class MainMarks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = s.nextInt();
        s.nextLine();
        
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for student " + (i + 1));
            System.out.print("Enter USN: ");
            String usn = s.nextLine();
            System.out.print("Enter Name: ");
            String name = s.nextLine();
            System.out.print("Enter Semester: ");
            int sem = s.nextInt();
            s.nextLine();
            
            Externals student = new Externals(usn, name, sem);
            
            // Display student details
            student.displayStudentInfo();
            
            // Get and display internal marks
            System.out.println("Enter internal marks:");
            student.getmarks();
            student.displaymarks();
            
            // Get and display external marks
            System.out.println("Enter external marks:");
            student.getextmarks();
            student.displayextmarks();
            
            // Calculate and display final marks
            student.finalmarks();
        }
        
        s.close();
    }
}
