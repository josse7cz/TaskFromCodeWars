package HandleExeption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            try {

                System.out.println("Enterr a whole numver for divide:");
                int a = sc.nextInt();
                System.out.println("Enter wole number to divide by:");
                int b = sc.nextInt();
                int z = a / b;
                System.out.println("Result:" + z);
            } catch (InputMismatchException e) {

                System.out.println("You cannot divide by anything else");
                System.out.println("Y should input whole number!");

            } finally {
                sc.close();
            }

    }
}
