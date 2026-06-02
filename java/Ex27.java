
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Ex27 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Cherry");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println("Sorted: " + list);
    }
}
