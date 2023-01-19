package OwnBubbleSort;

import java.util.Random;

public class BubbleSortMain {
    Random random = new Random();

    BubbleSortMain() {
    }

    public int[] getPole(int pocetPrvku) {
        int pole[] = new int[pocetPrvku];
        for (int i = 0; i < pocetPrvku; i++) {
            pole[i] = random.nextInt(10);
        }
        return pole;
    }

    public int[] seradPole(int[] serazenePole) {
        for (int i = 0; i < serazenePole.length; i++) {
            for (int j = 1; j < (serazenePole.length - i) ; j++) {
                if (serazenePole[j-1] > serazenePole[j]) {
                    int temp = serazenePole[j-1];
                    serazenePole[j-1] = serazenePole[j];
                    serazenePole[j] = temp;

                }
            }
        }


        return serazenePole;
    }


}
