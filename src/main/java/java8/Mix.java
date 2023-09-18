package java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Mix {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println("Consuming " + s);
        Supplier<String> supplier = () -> {
            return "Supplying sukh";
        };

        System.out.println(getResult(consumer, supplier, "dukh"));
    }

    private static String getResult(Consumer<String> consumer, Supplier<String> supplier, String consumeString) {
        if(consumeString.equals("dukh")) {
            // Consume dukh
            consumer.accept(consumeString);
        }

        if(consumeString.equals("dukh")) {
            // supply sukh
            return supplier.get();
        }

        return "hame nhi pata iska kya kare.";
    }
}
