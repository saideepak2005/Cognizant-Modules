
import java.util.Scanner;
public class Ex15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        if(sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println("Reversed: " + new StringBuilder(str).reverse().toString());
        }
    }
}
