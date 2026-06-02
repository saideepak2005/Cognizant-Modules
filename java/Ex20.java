
import java.util.Scanner;
public class Ex20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Num 1: ");
            int a = sc.nextInt();
            System.out.print("Num 2: ");
            int b = sc.nextInt();
            System.out.println("Result: " + (a/b));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }
    }
}
