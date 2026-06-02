
import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if(sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num % 2 == 0) System.out.println("Even");
            else System.out.println("Odd");
        }
    }
}
