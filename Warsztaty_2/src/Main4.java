import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Main4 {
    public static void main(String[] args) throws SQLException {
        DBConnection connection = null;

        try {
            connection = new DBConnection("programming_school", "root", "coderslab");

//            Solution solution = new Solution(DBDate.setDate(new Date()), DBDate.setDate(new Date()), "opis2", 2, 2 );


//            solution.setDescription("nowy opis");
//            solution.saveToDB(connection.getConnection());

//           Solution solution1 = Solution.loadSolutionById(connection.getConnection(),1);
//            solution1.setDescription("nowy opis 2");
//            exercise1.delete(connection.getConnection());
//            System.out.println(solution1.getId());
//            solution1.saveToDB(connection.getConnection());
//            Solution solution = new Solution("2019-03-12 02:23:33", "2019-03-12 02:23:33", "opis2", 2, 3);
//
//            solution.saveToDB(connection.getConnection());
//
//
            ArrayList<Solution> solutions = Solution.loadAllByExerciseId(connection.getConnection(),2);
            for (Solution solution1 : solutions) {
                System.out.println("id: " + solution1.getId() + " created:  " + solution1.getCreated() + " opis: " + solution1.getDescription());
            }

//            solutions.get(1).delete(connection.getConnection());

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.closeConnection();
        }
    }
}
