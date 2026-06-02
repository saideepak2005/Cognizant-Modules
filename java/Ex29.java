
import java.util.List;
record Person(String name, int age) {}
public class Ex29 {
    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Alice", 20), new Person("Bob", 15), new Person("Charlie", 25));
        people.forEach(System.out::println);
        System.out.println("Adults:");
        people.stream().filter(p -> p.age() >= 18).forEach(System.out::println);
    }
}
