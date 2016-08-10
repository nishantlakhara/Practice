package timeunits;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class SampleTimeUnit {
	private int startHour;
	private TimeUnit intervalUnit;
	private int interval;
	
	public static void main(String[] args) {
//		TimeUnit intervalUnit = TimeUnit.SECONDS;
//		final long interval = intervalUnit.toMillis(5);
//		System.out.println("Interval = " + interval);
//		System.out.println("Current time : " + System.currentTimeMillis());
//		final long initialDelay = (interval - (System.currentTimeMillis() % interval));
//		System.out.println(initialDelay);
//		System.out.println(10 % 0);
		
		SampleTimeUnit stu = new SampleTimeUnit();
		stu.startHour = 15;
		stu.interval = 1;
		stu.intervalUnit = TimeUnit.MINUTES;
		System.out.println((float)stu.getInitialDelay() / 1000 / 60 / 60);
		
		System.out.println(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis() - 31557600000l);
	}
	
	protected long getInitialDelay() {
		if (startHour > 0) {
			// Interval(In hours) to start utility after mid night.
			final int startHour = Math.max(this.startHour, 0);
			final Calendar cal = Calendar.getInstance();

			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.HOUR_OF_DAY, startHour);
			if (cal.getTimeInMillis() < System.currentTimeMillis()) {
				cal.add(Calendar.HOUR, 24);
			}
			return cal.getTimeInMillis() - System.currentTimeMillis();
		} else {
			final long interval = this.intervalUnit.toMillis(this.interval);
			System.out.println("Interval == " + interval + " ms");
			final long initialDelay = (interval - (System.currentTimeMillis() % interval));
			return initialDelay;
		}
	}
}
