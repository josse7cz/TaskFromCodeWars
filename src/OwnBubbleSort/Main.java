package OwnBubbleSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BubbleSortMain bs= new BubbleSortMain();
        int pole[]=bs.getPole(100);
        System.out.println(Arrays.toString(pole));

        System.out.println(Arrays.toString(bs.seradPole(pole)));






    }

}
