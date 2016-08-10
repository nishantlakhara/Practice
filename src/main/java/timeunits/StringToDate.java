package timeunits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StringToDate {
	public static void main(String[] args) {
		StringToDate std = new StringToDate();
		
		Date date1 = std.convertStringToDate("Mon, 16 Feb 2015 08:00:48 GMT" , "EEE, dd MMM yyyy HH:mm:ss z");
		Date date2 = std.convertStringToDate("Mon, 16 Feb 2015 08:01:49 GMT" , "EEE, dd MMM yyyy HH:mm:ss z");
		System.out.println(std.diffDates(date1, date2));
	}
	
	public Date convertStringToDate(String strDate , String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		//String dateInString = "Mon, 16 Feb 2015 08:00:48";
		Date date = null;
		try {
			 
			date = formatter.parse(strDate);
			System.out.println(date);
			System.out.println(formatter.format(date));
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public long diffDates(Date date1 , Date date2) {
		long diff = date2.getTime() - date1.getTime();
		return TimeUnit.MILLISECONDS.toSeconds(diff);
	}
}
