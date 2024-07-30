
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

 
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/uc11";
        String user = "root";
        String password = "Wagnerlucia10*";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

}