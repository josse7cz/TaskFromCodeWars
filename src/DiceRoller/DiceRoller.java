package DiceRoller;

import java.util.Arrays;
import java.util.Random;

public class DiceRoller {

    Random random = new Random();

    DiceRoller() {


    }

    public int[] roll(int polelength) {
        int pole[] = new int[polelength];
        for (int i = 0; i < polelength; i++) {
            pole[i] = random.nextInt(6);
            //System.out.print(number[i]+",");
        }
        return pole;

    }

    public int[] buble(int a[]) {
        int pole[] = a;
        int temp;

        for (int i = 0; i < pole.length; i++) {
            for (int j = 1; j < (pole.length - i); j++) { //nastaveni prave hranice pole
                if (pole[j - 1] > pole[j]) {
                    temp = pole[j - 1];
                    pole[j - 1] = pole[j];
                    pole[j] = temp;
                }
            }
        }
        return pole;
    }

    public int[] sort(int a[]) {
        Arrays.sort(a);
        int pole[] = a;
        return pole;
    }



//    public int[] buble(int arr[]) {
//        int n = arr.length;
//        for (int i = 0; i < n - 1; i++)
//            for (int j = 0; j < n - i - 1; j++)
//                if (arr[j] > arr[j + 1]) {
//                    // swap arr[j+1] and arr[j]
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//        return arr;
//    }


}
