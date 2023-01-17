/**
 * @author Josef Janda 2023
 * Trida vygeneruje nahodne pole zadane velikost pomoci Random a pole vypise
 * @param poleLenght
 * dale pomoci BubleSort setridi a vypise setrizene pole
 */
package DiceRoller;

public class Main {

    public static void main(String[] args) {
        int poleLenght = 10;
        DiceRoller dt = new DiceRoller();
        int[] pole = dt.roll(poleLenght);
        System.out.println("Nesetrizene pole");
        for (int e : pole) {
            System.out.print(e + ", ");
        }


//        System.out.println("\n"+"Setrizene pole: ");
//        dt.buble(pole);
//        for (int e : pole) {
//            System.out.print(e+ ", ");
//        }
        System.out.println("\n" + "Setrizene pole: ");
        dt.sort(pole);
        for (int e : pole) {
            System.out.print(e + ", ");
        }
    }
}
