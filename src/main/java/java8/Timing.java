package java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface Timing{

    public void execute();

    public static <T> long timed(Timing timer, Consumer<String> consumer) {
        long start = System.nanoTime();
        timer.execute();
        long stop = System.nanoTime();
        long diff = stop - start;
        consumer.accept("Executed in " + diff + " nanoseconds");
        return diff;
    }

    public static <T> long timed(Supplier<T> supplier, Consumer<String> consumer) {
        long start = System.nanoTime();
        T returned = supplier.get();
        long stop = System.nanoTime();
        long diff = stop - start;
        consumer.accept("Executed in " + diff + " nanoseconds. Returned value = " + returned.toString() );
        return diff;
    }
}
