package Vehicles;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Bicycle cycle = new Bicycle();
        car.speed=20;
        System.out.println("I am car with speed "+car.speed+ " with a "+car.doors+"doors");
        car.stop();
        System.out.println("Car new speed "+car.speed);
        cycle.wheels=3;
        System.out.println("I am bicycle "+cycle.wheels);

        car.whoami();
        cycle.whoami();

    }

}
