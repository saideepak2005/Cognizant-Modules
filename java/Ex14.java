
import java.util.Scanner;
public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements: ");
        if(sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            System.out.println("Enter elements:");
            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + (double)sum/n);
        }
    }
}
