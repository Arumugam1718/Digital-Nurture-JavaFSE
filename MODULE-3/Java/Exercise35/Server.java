import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Exercise35 - Server
 * 
 * Objective: Use Java sockets for TCP communication (Server side).
 * 
 * This program creates a TCP server socket that listens on port 5000.
 * When a client connects, it reads the client's message and sends back a response.
 * 
 * Run this class first in Terminal 1, then run Client.java in Terminal 2.
 */
public class Server {

    // Port number on which the server listens for incoming connections
    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Server Started...");
        System.out.println();

        // ServerSocket listens for incoming client connections on the specified port
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            // accept() blocks until a client connects, then returns a Socket for that client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Connected");
            System.out.println();

            // InputStream to read messages from the client
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            // OutputStream to send messages back to the client
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read the client's message
            String clientMessage = reader.readLine();
            System.out.println("Client:");
            System.out.println(clientMessage);
            System.out.println();

            // Send a response back to the client
            String serverResponse = "Hello Client";
            writer.println(serverResponse);
            System.out.println("Server:");
            System.out.println(serverResponse);

            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
