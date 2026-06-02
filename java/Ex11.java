
import java.util.Scanner;
public class Ex11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        if(sc.hasNextLong()) {
            long num = sc.nextLong();
            long fact = 1;
            for(long i = 1; i <= num; i++) {
                fact *= i;
            }
            System.out.println("Factorial: " + fact);
        }
    }
}
