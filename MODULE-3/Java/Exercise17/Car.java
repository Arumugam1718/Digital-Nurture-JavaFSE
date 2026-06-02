/**
 * Exercise17 - Car
 * 
 * Objective: Understand classes and objects in Java.
 * 
 * Key OOP Concepts:
 * 1. Class: A blueprint or template that defines the attributes and behaviors of a real-world entity.
 *    Here, 'Car' is the class.
 * 2. Object: An instance of a class. It is a concrete entity created from the blueprint.
 *    Here, 'car' in the main method is the object.
 * 3. Attributes: Fields or instance variables that represent the state or properties of a class.
 *    Here, 'brand', 'model', and 'year' are the attributes.
 * 4. Methods: Functions inside a class that define the actions or behavior that an object can perform.
 *    Here, 'displayDetails' is the method.
 */
public class Car {

    // Attributes (Instance Variables)
    String brand;
    String model;
    int year;

    // Method to display the details of the car
    void displayDetails() {
        System.out.println("Car Details");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Year  : " + year);
    }

    public static void main(String[] args) {
        // Creating an object of the Car class
        Car car = new Car();

        // Assigning values to the attributes of the object
        car.brand = "Toyota";
        car.model = "Camry";
        car.year = 2024;

        // Calling the method to display details
        car.displayDetails();
    }
}
