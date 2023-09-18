package java8;

import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> c = s -> {
            System.out.println("Consumed " + s);
        };

        Consumer<String> next = c.andThen((Object s) -> System.out.println("Consume again " + s.toString()));
        next.accept("dukh");
    }
}
