
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Ex22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write to file: ");
        if(sc.hasNextLine()) {
            String text = sc.nextLine();
            try (FileWriter fw = new FileWriter("output.txt")) {
                fw.write(text);
                System.out.println("Data written to output.txt successfully.");
            } catch (IOException e) { e.printStackTrace(); }
        }
    }
}
