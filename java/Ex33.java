
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
public class Ex33 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bank.db")) {
            conn.setAutoCommit(false);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance REAL)");
            stmt.execute("INSERT OR IGNORE INTO accounts (id, balance) VALUES (1, 1000), (2, 500)");
            
            try (PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + 100 WHERE id = 2")) {
                debit.executeUpdate();
                credit.executeUpdate();
                conn.commit();
                System.out.println("Transfer successful, transaction committed.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transfer failed, transaction rolled back.");
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
