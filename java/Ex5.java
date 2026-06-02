
import java.util.Scanner;
public class Ex5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        if (sc.hasNextInt()) {
            int num = sc.nextInt();
            for(int i=1; i<=10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
        }
    }
}
