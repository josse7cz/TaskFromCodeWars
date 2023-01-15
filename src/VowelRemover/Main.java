package VowelRemover;

public class Main {

    public static void main(String[] args) {
        shortcut("Hello");
    }
    public static String shortcut(String input) {
        return input.replaceAll("[aeiou]", "");
    }

}
