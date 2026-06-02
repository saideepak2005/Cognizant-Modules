
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Ex32 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:sample.db")) {
            conn.createStatement().execute("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT)");
            
            PreparedStatement insert = conn.prepareStatement("INSERT INTO students (name) VALUES (?)");
            insert.setString(1, "Alice");
            insert.executeUpdate();
            
            PreparedStatement update = conn.prepareStatement("UPDATE students SET name = ? WHERE id = ?");
            update.setString(1, "Alice Updated");
            update.setInt(2, 1);
            update.executeUpdate();
            System.out.println("Insert and Update successful.");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
