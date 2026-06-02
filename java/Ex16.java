
import java.util.Scanner;
public class Ex16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        if(sc.hasNextLine()) {
            String str = sc.nextLine().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            String rev = new StringBuilder(str).reverse().toString();
            System.out.println("Is Palindrome: " + str.equals(rev));
        }
    }
}
