
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
public class Ex41 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            System.out.println("Task executing...");
            return 42;
        };
        Future<Integer> future = exec.submit(task);
        System.out.println("Result: " + future.get());
        exec.shutdown();
    }
}
