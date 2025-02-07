package javaexamples.java8;

import java.util.function.Consumer;

public class TimingMain {

    public static void main(String[] args) {

        Timing hello = () -> {
            System.out.println("Hello");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Consumer<String> stringConsumer = t -> System.out.println(t);

        long timed = Timing.timed(hello, stringConsumer);

        timed = Timing.timed(() -> System.out.println("mast bas itna print karne me kitna time lagega"), stringConsumer);

    }

}
