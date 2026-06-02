
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Ex31 {
    public static void main(String[] args) {
        try {
            // Assume sqlite for simplicity to avoid local mysql setup issues
            Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            stmt.execute("INSERT INTO students (name) VALUES ('Test Student')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
            conn.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
