
import java.util.Scanner;
import java.util.Random;
public class Ex10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = new Random().nextInt(100) + 1;
        int guess = 0;
        while(guess != target) {
            System.out.print("Guess the number (1-100): ");
            if(!sc.hasNextInt()) break;
            guess = sc.nextInt();
            if(guess > target) System.out.println("Too high");
            else if(guess < target) System.out.println("Too low");
            else System.out.println("Correct!");
        }
    }
}
