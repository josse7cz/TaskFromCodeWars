package Vehicles;

public class Bicycle extends Vehicle{
    int pedals=2;
    int wheels=2;

    @Override
    void whoami() {
        System.out.println("I am a cycle!");
    }
}
