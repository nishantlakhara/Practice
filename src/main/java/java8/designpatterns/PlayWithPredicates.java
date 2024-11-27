package java8.designpatterns;

import java8.designpatterns.function.Predicate;

public class PlayWithPredicates {
    public static void main(String[] args) {
        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> !s.isEmpty();

        Predicate<String> p3 = p1.and(p2);
        System.out.println(p3.test(null));
        System.out.println(p3.test(""));
        System.out.println(p3.test("hello"));

        Predicate<String> notP2 = p2.negate();
        System.out.println(notP2.test("hello"));
    }
}
