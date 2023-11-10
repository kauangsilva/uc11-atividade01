
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

 
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/LeiloesTDSat";
        String user = "root";
        String password = "250580";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

}
