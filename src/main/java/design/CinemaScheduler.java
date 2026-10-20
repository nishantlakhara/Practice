package design;
import java.util.*;

public class CinemaScheduler {

    private static final int OPEN = 10 * 60;   // 10:00 AM
    private static final int CLOSE = 23 * 60;  // 11:00 PM
    private static final int BUFFER = 15;

    static class Show {
        String name;
        int start;
        int end;

        Show(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return name + " [" + toTime(start)
                    + " - " + toTime(end) + "]";
        }
    }

    static String toTime(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;

        String period = hour < 12 ? "AM" : "PM";
        int displayHour = hour % 12;

        if (displayHour == 0) {
            displayHour = 12;
        }

        return String.format(
                "%02d:%02d %s",
                displayHour, minute, period
        );
    }

    static int time(String value) {
        String[] parts = value.split(":");

        return Integer.parseInt(parts[0]) * 60
                + Integer.parseInt(parts[1]);
    }

    static List<Show> maximizeShows(
            List<Show> shows, int screenCount) {

        if (screenCount <= 0) {
            throw new IllegalArgumentException(
                    "Screen count must be positive"
            );
        }

        // Process shows in start-time order.
        shows.sort(Comparator.comparingInt(s -> s.start));

        // Active show with the earliest ending time.
        PriorityQueue<Show> earliestEnd = new PriorityQueue<>(
                Comparator.comparingInt(s -> s.end)
        );

        // Active show with the latest ending time.
        PriorityQueue<Show> latestEnd = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.end, a.end)
        );

        // All shows that are currently selected.
        Set<Show> selected = new HashSet<>();

        // Selected shows that still conflict with the current time.
        Set<Show> active = new HashSet<>();

        for (Show show : shows) {

            // Reject invalid movie schedules.
            if (show.start < OPEN
                    || show.end > CLOSE
                    || show.start >= show.end) {
                continue;
            }

            // Expire shows that have finished, including
            // the required buffer before the next show.
            while (!earliestEnd.isEmpty()
                    && earliestEnd.peek().end + BUFFER
                    <= show.start) {       // End < Start -> No Overlapping

                Show finished = earliestEnd.poll();
                active.remove(finished);
            }

            // Accept the new show temporarily.
            selected.add(show);
            active.add(show);

            earliestEnd.offer(show);
            latestEnd.offer(show);

            // Too many simultaneous shows?
            // Remove the one that finishes latest.
            if (active.size() > screenCount) {

                // Skip shows that have already expired
                // or were previously rejected.
                while (!latestEnd.isEmpty()
                        && !active.contains(latestEnd.peek())) {
                    latestEnd.poll();
                }

                Show removed = latestEnd.poll();

                active.remove(removed);
                selected.remove(removed);
            }
        }

        // Return every selected show, including those
        // that finished earlier in the day.
        List<Show> result = new ArrayList<>(selected);
        result.sort(Comparator.comparingInt(s -> s.start));

        return result;
    }

    public static void main(String[] args) {

        int screenCount = 2;

        List<Show> shows = new ArrayList<>();

//         Movie name, start time, end time
        shows.add(new Show("Movie A", time("10:00"), time("12:00")));
        shows.add(new Show("Movie B", time("10:30"), time("11:30")));
        shows.add(new Show("Movie C", time("11:00"), time("13:00")));
        shows.add(new Show("Movie D", time("12:15"), time("14:00")));
        shows.add(new Show("Movie E", time("13:00"), time("15:00")));
        shows.add(new Show("Movie F", time("14:15"), time("16:00")));
        shows.add(new Show("Movie G", time("16:00"), time("18:00")));
        shows.add(new Show("Movie H", time("18:15"), time("20:00")));
        shows.add(new Show("Movie I", time("20:00"), time("22:00")));
        shows.add(new Show("Movie J", time("21:00"), time("22:30")));


//         Set 2 with 2 screen count
//        shows.add(new Show("Movie A", time("10:00"), time("12:00")));
//        shows.add(new Show("Movie B", time("10:30"), time("11:45")));
//        shows.add(new Show("Movie C", time("11:00"), time("11:30")));

        List<Show> result = maximizeShows(shows, screenCount);

        System.out.println("Number of screens: " + screenCount);
        System.out.println("Maximum selected shows: " + result.size());
        System.out.println("----------------------------------------");

        for (Show show : result) {
            System.out.println(show);
        }
    }
}
