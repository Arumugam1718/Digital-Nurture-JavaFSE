/**
 * Exercise26 - ThreadDemo
 * 
 * Objective: Implement multithreading.
 * 
 * This program implements two concurrent threads using the Runnable interface.
 * Thread 1 processes student records, and Thread 2 generates reports. Small delays
 * are introduced using Thread.sleep() to encourage interleaved execution.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        
        // Thread 1 task: Processing records
        Runnable recordProcessor = () -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("Processing Student Records");
                try {
                    // Sleep to allow the other thread to run concurrently
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Thread 2 task: Generating reports
        Runnable reportGenerator = () -> {
            for (int i = 0; i < 2; i++) {
                System.out.println("Generating Reports");
                try {
                    // Sleep to allow the other thread to run concurrently
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Instantiate Thread objects passing the Runnable tasks
        Thread thread1 = new Thread(recordProcessor);
        Thread thread2 = new Thread(reportGenerator);

        // Start both threads, which calls their respective run() methods
        thread1.start();
        thread2.start();

        // Ensure main thread waits for both threads to finish before exiting
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
