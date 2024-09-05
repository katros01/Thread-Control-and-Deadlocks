public class ThreadInterruption {
    private final Thread thread = new Thread(() -> {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("Counting: " + i);
                Thread.sleep(1000);
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread was interrupted, stopping...");
                    return;
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted during sleep.");
        }
    });

    public void demonstrateThreadInterruption() {

        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
