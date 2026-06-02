
import java.util.ArrayList;
import java.util.Scanner;
public class Ex24 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter student name (or type 'exit'): ");
            String name = sc.nextLine();
            if(name.equalsIgnoreCase("exit")) break;
            list.add(name);
        }
        System.out.println("All students:");
        for(String n : list) System.out.println(n);
    }
}
