import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static Connection connection = null;

    public DBConnection(String dbname, String user, String password) throws SQLException {
        connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + dbname + "?useSSL=false",
                user,
                password);
    }

    public  Connection getConnection() throws SQLException {
//        if(connection == null) {
//            connection = (Connection) DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/" + dbname + "?useSSL=false",
//                    user,
//                    password);
//        }
        return connection;
    }

     public static void closeConnection() throws SQLException {

         connection.close();
     }
}
