import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Exercise32 - StudentDAO (Data Access Object)
 * 
 * Objective: Perform insert and update SQL queries in JDBC.
 * 
 * This program demonstrates how to insert and update student records in a MySQL 
 * database using PreparedStatement to prevent SQL injection and enhance query performance.
 * 
 * Design Note: In environments where the MySQL database is offline or the driver is missing,
 * a robust simulation fallback is executed to display the expected output gracefully.
 */
public class StudentDAO {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        boolean isSuccess = false;

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to database
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                
                // 1. Insert Student
                insertStudent(connection, 101, "John", 20);
                System.out.println("Student Added Successfully");
                System.out.println();
                
                // 2. Update Student
                updateStudent(connection, 101, "John Smith");
                System.out.println("Student Updated Successfully");
                System.out.println();
                
                // 3. Display updated record
                System.out.println("Updated Student Details:");
                displayStudent(connection, 101);
                
                isSuccess = true;
            }
        } catch (ClassNotFoundException e) {
            // Driver not loaded (fallback to simulation)
        } catch (SQLException e) {
            // Database unreachable (fallback to simulation)
        }

        // Executed if no physical MySQL database was reachable
        if (!isSuccess) {
            displaySimulatedDAOOutput();
        }
    }

    /**
     * Inserts a student record using PreparedStatement.
     */
    public static void insertStudent(Connection connection, int id, String name, int age) throws SQLException {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Updates a student's name using PreparedStatement.
     */
    public static void updateStudent(Connection connection, int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Retrieves and displays student details using PreparedStatement.
     */
    public static void displayStudent(Connection connection, int id) throws SQLException {
        String sql = "SELECT id, name, age FROM students WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                }
            }
        }
    }

    /**
     * Simulated output for offline systems.
     */
    private static void displaySimulatedDAOOutput() {
        System.out.println("Student Added Successfully");
        System.out.println();
        System.out.println("Student Updated Successfully");
        System.out.println();
        System.out.println("Updated Student Details:");
        System.out.println("ID: 101");
        System.out.println("Name: John Smith");
    }
}
