package SEE;

import CIE.Student;
import CIE.Internals;
import java.util.Scanner;

public class Externals extends Internals {
    public int[] extmarks = new int[5];

    public Externals(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    public void getextmarks() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter external marks for course " + (i + 1) + ":");
            extmarks[i] = s.nextInt();
            s.nextLine();
        }
    }

    public void displayextmarks() {
        System.out.println("External Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + extmarks[i]);
        }
    }

    public void finalmarks() {
        System.out.println("Final Marks (Internal + External):");
        for (int i = 0; i < 5; i++) {
            int finalMark = marks[i] + extmarks[i];
            System.out.println("Course " + (i + 1) + ": " + finalMark);
        }
    }
}

