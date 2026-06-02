import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Exercise41 - ExecutorCallableDemo
 * 
 * Objective: Use concurrency utilities — ExecutorService and Callable.
 * 
 * ─────────────────────────────────────────────
 * KEY CONCEPTS:
 * ─────────────────────────────────────────────
 * ExecutorService       → A managed thread pool that controls how tasks are
 *                         scheduled and executed. Avoids manually creating threads.
 * 
 * Callable<V>           → Like Runnable, but can RETURN a value and throw exceptions.
 *                         Runnable.run() returns void; Callable.call() returns <V>.
 * 
 * Future<V>             → A handle to the result of an asynchronous Callable.
 *                         Future.get() blocks until the result is available.
 * 
 * Executors.newFixedThreadPool(n) → Creates a pool of exactly n reusable threads.
 *                         Tasks exceeding n are queued until a thread is free.
 * 
 * executor.shutdown()   → Signals the pool to stop accepting new tasks and 
 *                         gracefully finish all submitted tasks.
 * ─────────────────────────────────────────────
 */
public class ExecutorCallableDemo {

    public static void main(String[] args) {
        // Create a fixed thread pool of 3 worker threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Hold Future results for later retrieval
        List<Future<String>> futureResults = new ArrayList<>();

        // Submit 3 Callable tasks to the executor
        for (int taskNumber = 1; taskNumber <= 3; taskNumber++) {
            final int taskId = taskNumber;

            // Callable task: performs student processing and returns a result string
            Callable<String> studentTask = () -> {
                // Simulate processing time per student task
                Thread.sleep(100);
                System.out.println("Task " + taskId + " Completed");
                return "Student Processed Successfully";
            };

            // Submit the Callable and store the Future handle
            Future<String> future = executor.submit(studentTask);
            futureResults.add(future);
        }

        // Collect and display all results after tasks finish
        System.out.println();
        System.out.println("Collected Results:");
        System.out.println();

        for (Future<String> future : futureResults) {
            try {
                // future.get() blocks until the task completes and the result is available
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task was interrupted.");
            } catch (ExecutionException e) {
                System.out.println("Task failed with error: " + e.getCause().getMessage());
            }
        }

        // Shutdown the executor — prevents new tasks and lets running tasks complete
        executor.shutdown();
    }
}
