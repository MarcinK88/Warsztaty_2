import java.sql.SQLException;
import java.util.ArrayList;

public class Main5 {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");


            ArrayList<Group> groups = Group.loadAllGroups(connection.getConnection());
            for (Group group : groups) {
                System.out.println("id: " + group.getId() + " name:  " + group.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
}
