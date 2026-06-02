/**
 * Parent class representing a general Vehicle.
 * It contains common properties and methods for all types of vehicles.
 */
class Vehicle {
    
    // Method to start the vehicle
    void start() {
        System.out.println("Vehicle is Starting...");
    }
}

/**
 * Child class representing a Car, inheriting from the Vehicle class.
 * The 'extends' keyword is used to establish inheritance.
 * By inheriting from Vehicle, the Car class inherits the start() method.
 */
class Car extends Vehicle {
    
    // Subclass-specific method
    void drive() {
        System.out.println("Car is Moving...");
    }
}

/**
 * Exercise18 - VehicleInheritance
 * 
 * Objective: Understand inheritance and code reusability.
 * 
 * Key Inheritance Concepts:
 * 1. Superclass (Parent): The class whose features are inherited (Vehicle).
 * 2. Subclass (Child): The class that inherits the features of the parent (Car).
 * 3. Code Reusability: By extending Vehicle, the Car class automatically gains the 
 *    start() method, preventing code duplication.
 */
public class VehicleInheritance {

    public static void main(String[] args) {
        // Creating an instance of the child class
        Car car = new Car();

        // Calling the method inherited from the parent class (Vehicle)
        car.start();

        // Calling the method defined specifically inside the child class (Car)
        car.drive();
    }
}
