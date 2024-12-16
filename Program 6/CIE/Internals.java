package CIE;

import java.util.Scanner;

public class Internals extends Student {
    public int[] marks = new int[5];

    public Internals(String usn, String name, int sem) {
        super(usn, name, sem);
    }

    public void getmarks() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter internal marks for course " + (i + 1) + ":");
            marks[i] = s.nextInt();
            s.nextLine();
        }
    }

    public void displaymarks() {
        System.out.println("Internal Marks:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + marks[i]);
        }
    }
}
