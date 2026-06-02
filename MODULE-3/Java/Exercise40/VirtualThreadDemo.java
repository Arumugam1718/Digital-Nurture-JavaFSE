import java.util.ArrayList;
import java.util.List;

/**
 * Exercise40 - VirtualThreadDemo
 * 
 * Objective: Use lightweight virtual threads (Java 21) for scalable concurrency.
 * 
 * ─────────────────────────────────────────────
 * VIRTUAL THREADS vs PLATFORM THREADS:
 * ─────────────────────────────────────────────
 * Platform Thread  → maps 1:1 to an OS thread. Creating 100,000 is expensive
 *                    (each uses ~1MB of stack by default).
 * Virtual Thread   → managed by the JVM, not the OS. Extremely lightweight.
 *                    Creating 100,000 virtual threads uses only a fraction of the
 *                    memory and startup time of the same number of platform threads.
 * 
 * When to use Virtual Threads:
 *   → I/O-bound tasks (file, network, database waiting)
 *   → High-concurrency servers (handling thousands of simultaneous connections)
 *   → Drop-in replacement for platform threads in blocking code paths
 * 
 * API used (Java 21):
 *   Thread.startVirtualThread(Runnable) → creates and immediately starts a virtual thread.
 */
public class VirtualThreadDemo {

    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Launching Virtual Threads...");
        System.out.println();

        // Track all launched virtual threads so we can wait for them to finish
        List<Thread> virtualThreads = new ArrayList<>();

        // Record start time for measuring execution duration
        long startTime = System.currentTimeMillis();

        // Launch THREAD_COUNT virtual threads — each prints one task message
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread vThread = Thread.startVirtualThread(() -> {
                // Each virtual thread independently executes this task
                System.out.println("Processing Task");
            });
            virtualThreads.add(vThread);
        }

        // Wait for all virtual threads to complete before measuring time
        for (Thread vThread : virtualThreads) {
            vThread.join();
        }

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        System.out.println();
        System.out.println("Execution Completed");
        System.out.println();
        System.out.println("Time Taken:");
        System.out.println(timeTaken + " ms");
        System.out.println();
        System.out.println("Total Virtual Threads Launched: " + THREAD_COUNT);
        System.out.println("Note: Equivalent platform threads would be significantly slower");
        System.out.println("      and consume ~100 GB of stack memory combined.");
    }
}
