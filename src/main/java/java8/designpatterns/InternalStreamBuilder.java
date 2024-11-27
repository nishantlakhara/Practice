package java8.designpatterns;

import java.util.stream.Stream;

public class InternalStreamBuilder {
    public static void main(String[] args) {

        // 2 phases.
        Stream.Builder<String> builder = Stream.builder();
        builder.add("one");
        builder.add("two");
        builder.add("three");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);


    }
}
