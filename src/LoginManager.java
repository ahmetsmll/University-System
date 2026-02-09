import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginManager {

    public boolean loginCheck(String username, String password) {
        boolean result = false;

      
        Connection conn = DBConnection.connect();

        try {
            
            String sql = "SELECT * FROM teachers WHERE username = ? AND password = ?";

           
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);  
            pst.setString(2, password);  

           
            ResultSet rs = pst.executeQuery();

            
            if (rs.next()) {
                result = true;
            }

            
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();  
        }

        return result;  
    }
}

