package cz.josef.janda.CountSheep;

public class Main {
    public static void main(String[] args) {

       countSheeps(array1);
    }


    public static int countSheeps(Boolean[] arrayOfSheeps) {


        int i;
        int sum = 0;
        boolean bol;
        for (i = 0; i < arrayOfSheeps.length; i++) {

            if (arrayOfSheeps[i] != null) {

                bol = arrayOfSheeps[i];
                if (bol) {
                    sum++;
                }
            }
        }// TODO May the force be with you
        System.out.println(sum);
        return sum;

    }

    static Boolean[] array1 = { true, true, true, false,
            true, true, true, true,
            true, false, true, false,
            true, false, false, true,
            true, true, true, true,
            false, false, true, true};


}
