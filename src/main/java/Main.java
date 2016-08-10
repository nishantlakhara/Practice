import java.sql.Date;
import java.sql.Timestamp;


public class Main {
	public static void main(String[] args) {
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		  Date date = new Date(stamp.getTime());
		  System.out.println(date);
	}
}
