package javaexamples.java8;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        Function<String, Integer> fun = s -> {
            return Integer.valueOf(s);
        };

        System.out.println(fun.apply("123"));
        // System.out.println(fun.apply("MEIntegerStringNhiHoonMeFatunga"));

        Function<Number, Number> funny = (i) -> ((Integer)i + 1);
        System.out.println(funny.apply(Integer.valueOf(100)));
        // System.out.println(funny.apply(Double.valueOf(100.0)));

        Function<String, Integer> fun1 = (s) -> {
            System.out.println("Converting string to integer");
            return Integer.valueOf(s);
        };
        Function<String, String> fun2 = fun1.andThen(i -> {
            System.out.println("Converting integer to string");
            return String.valueOf(i);
        });
        fun2.apply("10");
    }
}
