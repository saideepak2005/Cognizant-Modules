
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
public class Ex35Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("Server started on port 8888");
        Socket client = server.accept();
        System.out.println("Client connected");
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        out.write("Hello from server
".getBytes());
        server.close();
    }
}
