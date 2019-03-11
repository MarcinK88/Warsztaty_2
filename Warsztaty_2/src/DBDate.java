import java.text.SimpleDateFormat;
import java.util.Date;

public class DBDate {
    public DBDate(){

    }

    public static String setDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);

    }
}
