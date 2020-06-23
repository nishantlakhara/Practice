package design_patterns.state;

public class DurationUtil {
    public static void addSleepDuration(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
