package Vehicles;

public class Vehicle {
    double speed;
    String color;
    String name;
    int wheels;

    void go(){
        speed=5 ;
        System.out.println("Jedu");

    }
    void stop(){
        speed=0;
        System.out.println("Brzdím");
    }
    void whoami(){
        System.out.println("I am vehicle");
    }


}
