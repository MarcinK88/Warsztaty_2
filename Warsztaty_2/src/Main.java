import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
}
