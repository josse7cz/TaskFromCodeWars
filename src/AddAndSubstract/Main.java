package AddAndSubstract;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddSubstract addSubstract = new AddSubstract();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter first number: ");
        int a = Integer.parseInt(myObj.nextLine());

        System.out.println("Enter second number: ");
        int b = Integer.parseInt(myObj.nextLine());

        System.out.println("Enter + or -: ");
        String sign = myObj.next();
        boolean q =sign.contains("+");
        System.out.println(sign.contains("+"));
        addSubstract.addAndSubstract(a, b, q);
    }
}
