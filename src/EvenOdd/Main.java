package EvenOdd;

public class Main {

    public static void main(String[] args) {
        even_or_odd(6);
    }

    public static String even_or_odd(int number) {
        if (number % 2 == 0) {
           return "Even";
        }
        System.out.println("Even");
        return "Odd";
    }
}