/**
 * Interface representing a drivable contract.
 * Interfaces define the "what" a class should do, but not the "how" (achieving Abstraction).
 */
interface Drivable {
    // Abstract method (has no body)
    void drive();
}

/**
 * Class representing a Car that implements the Drivable interface.
 * The 'implements' keyword binds the class to the interface contract,
 * requiring it to override and implement the drive() method.
 */
class Car implements Drivable {

    // Overriding the abstract method from the interface
    @Override
    public void drive() {
        System.out.println("Car is Driving...");
    }
}

/**
 * Exercise19 - InterfaceDemo
 * 
 * Objective: Understand abstraction using interfaces.
 * 
 * Key Concepts:
 * 1. Interface: A completely abstract class used to group related methods with empty bodies.
 * 2. Abstraction: Hiding implementation details and only showing the interface to the outside world.
 * 3. Contract: A class implementing an interface must provide the implementation for all its methods.
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        // Creating an object of the implementing class
        Car car = new Car();

        // Calling the implemented drive() method
        car.drive();
    }
}
