import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main3 {
    public static void main(String[] args) {

        Solution solution = new Solution();

//        solution.setCreated(java.time.LocalDate.now());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sd = sdf.format(date);
        System.out.println(DBDate.setDate(new Date()));




    }
}
