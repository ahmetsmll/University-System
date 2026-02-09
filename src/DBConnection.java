import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/university_system2", "root", "2rpk2tvh"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
