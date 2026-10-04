class Vehicle {
    String brand;
    int speed;

    public Vehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    public void start() {
        System.out.println("The " + brand + " vehicle is starting.");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String brand, int speed, int numberOfDoors) {
        super(brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("The " + brand + " car starts with a key ignition.");
    }
}

class Bike extends Vehicle {
    boolean hasCarrier;

    public Bike(String brand, int speed, boolean hasCarrier) {
        super(brand, speed);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void start() {
        System.out.println("The " + brand + " bike starts with a kick/button start.");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle myCar = new Car("Toyota", 120, 4);
        Vehicle myBike = new Bike("Yamaha", 80, true);

        myCar.start();
        myBike.start();
    }
}