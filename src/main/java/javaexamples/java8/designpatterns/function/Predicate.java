package javaexamples.java8.designpatterns.function;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (T t) -> this.test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        // its a this object. So not need to test null checks
        return (T t) -> !this.test(t);
    }
}
