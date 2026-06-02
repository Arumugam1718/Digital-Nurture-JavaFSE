import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Exercise36 - HttpClientDemo
 * 
 * Objective: Make HTTP requests from Java using the modern HttpClient API (Java 11+).
 * 
 * Key Concepts:
 * 1. HttpClient  : The entry point; manages connections, redirects, and authentication.
 * 2. HttpRequest : Immutable object describing the HTTP request (method, URI, headers).
 * 3. HttpResponse: Contains the response status code, headers, and body.
 * 
 * The request follows this lifecycle:
 * Build HttpClient → Build HttpRequest → Send → Receive HttpResponse → Process body
 */
public class HttpClientDemo {

    private static final String API_URL = "https://api.github.com/users/octocat";

    public static void main(String[] args) {
        // Build a reusable HttpClient with a 10-second connect timeout
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Build an HTTP GET request targeting the GitHub API endpoint
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            // Send the request synchronously; body is returned as a String
            HttpResponse<String> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println();
            System.out.println("Response Body:");
            System.out.println(response.body());

        } catch (IOException e) {
            System.out.println("Network Error: " + e.getMessage());
            System.out.println("Check your internet connection and try again.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Request interrupted: " + e.getMessage());
        }
    }
}
