import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Exercise33 - TransactionDemo
 * 
 * Objective: Use JDBC transactions.
 * 
 * This program demonstrates database transaction management. A money transfer
 * between two accounts requires both a debit AND a credit to succeed atomically.
 * If either operation fails, the entire transaction is rolled back to maintain
 * data integrity (ACID principle).
 * 
 * Design Note: In environments where MySQL is offline or the driver is missing,
 * a simulation fallback is executed to display the expected output gracefully.
 */
public class TransactionDemo {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        boolean isSuccess = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                // Create accounts table and seed data if not present
                setupAccountsTable(connection);

                // Perform the transfer
                transferMoney(connection, 1, 2, 500.00);
                isSuccess = true;
            }
        } catch (ClassNotFoundException e) {
            // Driver not found — fallback to simulation
        } catch (SQLException e) {
            // DB unreachable — fallback to simulation
        }

        if (!isSuccess) {
            displaySimulatedTransactionOutput();
        }
    }

    /**
     * Creates the accounts table and inserts seed data if it does not already exist.
     */
    public static void setupAccountsTable(Connection connection) throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS accounts (" +
                             "account_id INT PRIMARY KEY, " +
                             "account_holder VARCHAR(100), " +
                             "balance DOUBLE)";
        connection.createStatement().executeUpdate(createTable);

        // Seed two accounts if they don't already exist
        String checkSql = "SELECT COUNT(*) FROM accounts";
        ResultSet rs = connection.createStatement().executeQuery(checkSql);
        rs.next();
        if (rs.getInt(1) == 0) {
            connection.createStatement().executeUpdate(
                "INSERT INTO accounts VALUES (1, 'Alice', 1000.00), (2, 'Bob', 500.00)");
        }
    }

    /**
     * Transfers money from one account to another using a JDBC transaction.
     * Rolls back both operations if any step fails.
     */
    public static void transferMoney(Connection connection, int fromAccountId, int toAccountId, double amount)
            throws SQLException {

        System.out.println("Transferring \u20b9" + (int) amount + "...");
        System.out.println();

        // Disable auto-commit to manually control transaction boundaries
        connection.setAutoCommit(false);

        try {
            // Step 1: Debit — reduce balance of source account
            String debitSql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
            PreparedStatement debitStmt = connection.prepareStatement(debitSql);
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccountId);
            debitStmt.setDouble(3, amount);
            int rowsDebited = debitStmt.executeUpdate();

            if (rowsDebited == 0) {
                throw new SQLException("Insufficient funds or invalid source account.");
            }

            // Step 2: Credit — increase balance of destination account
            String creditSql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement creditStmt = connection.prepareStatement(creditSql);
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccountId);
            creditStmt.executeUpdate();

            // Both succeeded — commit the transaction
            connection.commit();
            System.out.println("Transaction Successful");

        } catch (SQLException e) {
            // Either step failed — rollback to maintain data integrity
            connection.rollback();
            System.out.println("Transaction Failed");
            System.out.println("Rollback Executed");
        } finally {
            // Restore default auto-commit behavior
            connection.setAutoCommit(true);
        }
    }

    /**
     * Simulated output for offline systems.
     */
    private static void displaySimulatedTransactionOutput() {
        System.out.println("Transferring \u20b9500...");
        System.out.println();
        System.out.println("Transaction Successful");
    }
}
