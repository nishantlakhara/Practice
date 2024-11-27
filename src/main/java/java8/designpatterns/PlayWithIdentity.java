package java8.designpatterns;

import java8.designpatterns.function.Function;

public class PlayWithIdentity {
    public static void main(String[] args) {

        // Using normal apply method.
        Function<String, String> identity = s -> s;

        Function<String, String> identity1 = Function.identity();

        System.out.println(identity1.apply("A"));
    }
}
