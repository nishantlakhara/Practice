package timeunits;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class SampleCalendar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SampleCalendar sc = new SampleCalendar();
		Calendar cal = sc.getCalendarTime(2014,8,24,9,18,18);
		Calendar currentCal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(currentCal);
		long calDiff = cal.getTime().getTime() - currentCal.getTime().getTime();
		long no_of_days = TimeUnit.MILLISECONDS.toDays(calDiff);
		System.out.println("Days : " + no_of_days);
	}
	
	public Calendar getCalendarTime(int years , int months , int day_of_month , int hour_of_day , int minutes , int seconds ) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Calendar calendar = new GregorianCalendar(years,months,day_of_month,hour_of_day,minutes,seconds);
		//Calendar calendar = new GregorianCalendar(2013,1,28,13,24,56);
		int year       = calendar.get(Calendar.YEAR);
		int month      = calendar.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH); 
		int dayOfWeek  = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar.get(Calendar.WEEK_OF_MONTH);
	 
		int hour       = calendar.get(Calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar.get(Calendar.MINUTE);
		int second     = calendar.get(Calendar.SECOND);
		int millisecond= calendar.get(Calendar.MILLISECOND);
	 
//		System.out.println(sdf.format(calendar.getTime()));
//	 
//		System.out.println("year \t\t: " + year);
//		System.out.println("month \t\t: " + month);
//		System.out.println("dayOfMonth \t: " + dayOfMonth);
//		System.out.println("dayOfWeek \t: " + dayOfWeek);
//		System.out.println("weekOfYear \t: " + weekOfYear);
//		System.out.println("weekOfMonth \t: " + weekOfMonth);
//	 
//		System.out.println("hour \t\t: " + hour);
//		System.out.println("hourOfDay \t: " + hourOfDay);
//		System.out.println("minute \t\t: " + minute);
//		System.out.println("second \t\t: " + second);
//		System.out.println("millisecond \t: " + millisecond);
		
		return calendar;
	}
	
	public void addCal(int days) {
		Calendar maxValue = Calendar.getInstance();
		System.out.println(maxValue);
		maxValue.add(Calendar.DATE, days);
		System.out.println(maxValue);
	}

}
