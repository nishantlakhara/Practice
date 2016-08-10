package weird;

import java.sql.Date;
import java.util.Calendar;

public class weird {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		preProcess(cal);
	}
		
		private static Calendar preProcess(Calendar cal) {
			int[] notifyBefore = {1, 2, 3, 7, 15, 30 ,60};
			
			//Iterate through each expiryTime. Set calendar to the latest match,
			for(int i=0;i<notifyBefore.length;i++)  {
				cal.add(Calendar.DATE, notifyBefore[i]);
				System.out.println(cal.getTime());
				cal.add(Calendar.DATE, -notifyBefore[i]);
				System.out.println(cal.getTime());
			}
			return cal;
		}
	

}
