package java8.designpatterns.function;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
