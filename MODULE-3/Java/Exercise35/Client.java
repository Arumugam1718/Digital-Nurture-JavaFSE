import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Exercise35 - Client
 * 
 * Objective: Use Java sockets for TCP communication (Client side).
 * 
 * This program connects to the server running on localhost:5000,
 * sends a greeting message, and displays the server's response.
 * 
 * Run Server.java first in Terminal 1, then run this class in Terminal 2.
 */
public class Client {

    // Server host and port to connect to
    private static final String HOST = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {

        // Socket connects to the server at the given host and port
        try (Socket socket = new Socket(HOST, PORT)) {

            // OutputStream to send messages to the server
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // InputStream to receive responses from the server
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send a message to the server
            String clientMessage = "Hello Server";
            writer.println(clientMessage);
            System.out.println("Client:");
            System.out.println(clientMessage);
            System.out.println();

            // Read and display the server's response
            String serverResponse = reader.readLine();
            System.out.println("Server:");
            System.out.println(serverResponse);

        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());
            System.out.println("Ensure Server.java is running before starting the Client.");
        }
    }
}
