
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Ex23 {
    public static void main(String[] args) {
        try (Scanner fileSc = new Scanner(new File("output.txt"))) {
            System.out.println("Reading from output.txt:");
            while(fileSc.hasNextLine()) {
                System.out.println(fileSc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("output.txt not found.");
        }
    }
}
