
public class Ex40 {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100000; i++) {
            Thread.startVirtualThread(() -> {
                // System.out.println("Virtual thread running");
                // Commented to avoid flooding output
            });
        }
        System.out.println("100,000 Virtual threads started.");
        Thread.sleep(1000); // give them time to run
    }
}
