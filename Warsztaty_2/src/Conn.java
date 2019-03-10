import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {

    public static Connection getConnection() throws SQLException {

        Connection  connection = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/programming_school?useSSL=false",
                    "root",
                    "coderslab");

        return connection;
    }

}
