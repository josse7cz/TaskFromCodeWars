package Vehicles;

public class Car extends Vehicle{
    int doors=4;

    @Override
    void whoami() {
        System.out.println("I am car!");
    }
}

