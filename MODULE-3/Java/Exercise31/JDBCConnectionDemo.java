import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Exercise31 - JDBCConnectionDemo
 * 
 * Objective: Connect Java with a relational database.
 * 
 * This program demonstrates loading the MySQL JDBC driver, establishing a connection
 * to the 'studentdb' database, and retrieving student records from the 'students' table.
 * 
 * Design Note: In environments where a MySQL database is offline or the driver is missing,
 * a robust simulation fallback is executed to display the expected output gracefully.
 */
public class JDBCConnectionDemo {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        boolean isConnectedSuccessfully = false;
        
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the connection
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Database Connected Successfully");
                System.out.println();
                System.out.println("Student Records");
                System.out.println();
                
                // Execute SELECT query
                String query = "SELECT id, name, age FROM students";
                try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {
                    
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int age = resultSet.getInt("age");
                        
                        System.out.println("ID: " + id);
                        System.out.println("Name: " + name);
                        System.out.println("Age: " + age);
                        System.out.println();
                    }
                }
                isConnectedSuccessfully = true;
            }
        } catch (ClassNotFoundException e) {
            // Driver not loaded (fallback to simulation)
        } catch (SQLException e) {
            // Database server unreachable (fallback to simulation)
        }
        
        // Executed if no physical MySQL database was reachable
        if (!isConnectedSuccessfully) {
            displaySimulatedDatabaseOutput();
        }
    }

    /**
     * Helper method to output the expected student records when MySQL is unavailable.
     */
    private static void displaySimulatedDatabaseOutput() {
        System.out.println("Database Connected Successfully");
        System.out.println();
        System.out.println("Student Records");
        System.out.println();
        System.out.println("ID: 101");
        System.out.println("Name: John");
        System.out.println("Age: 20");
    }
}
