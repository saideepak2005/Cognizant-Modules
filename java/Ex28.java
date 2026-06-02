
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Ex28 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Evens: " + evens);
    }
}
