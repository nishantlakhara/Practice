package java8.designpatterns;

import java8.designpatterns.function.Consumer;

public class PlayWithConsumers {

    public static void main(String[] args) {
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = s -> System.out.println(s);

        Consumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("hello");

        // Create a default method to do this via chaining
        Consumer<String> c4 = c1.andThen(c2);
        c4.accept("andThen created");

        try {
            // Handle this use case as well.
            Consumer<String> c5 = c1.andThen(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
