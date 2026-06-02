
import java.util.HashMap;
import java.util.Scanner;
public class Ex25 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Enter ID (or -1 to stop): ");
            int id = sc.nextInt();
            if(id == -1) break;
            System.out.print("Enter Name: ");
            String name = sc.next();
            map.put(id, name);
        }
        System.out.print("Enter ID to retrieve: ");
        int query = sc.nextInt();
        System.out.println("Name: " + map.getOrDefault(query, "Not Found"));
    }
}
