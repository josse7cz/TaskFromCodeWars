package TestClass;

import java.util.Random;

public class DiceRoller {
    Random random;
    int number;

    DiceRoller() {
        random = new Random();

    }

    public void roll() {
        for (int i = 0;i<10;i++){
            number= random.nextInt(6);
            System.out.println(number);
        }

    }

}
