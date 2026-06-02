
import java.net.Socket;
import java.io.InputStream;
import java.util.Scanner;
public class Ex35Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8888);
        Scanner sc = new Scanner(socket.getInputStream());
        System.out.println("Server says: " + sc.nextLine());
        socket.close();
    }
}
