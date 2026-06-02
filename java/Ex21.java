
import java.util.Scanner;
public class Ex21 {
    public static void checkAge(int age) throws InvalidAgeException {
        if(age < 18) throw new InvalidAgeException("Age less than 18 not allowed.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        if(sc.hasNextInt()) {
            try {
                checkAge(sc.nextInt());
                System.out.println("Access granted.");
            } catch (InvalidAgeException e) {
                System.out.println("Caught Exception: " + e.getMessage());
            }
        }
    }
}
