package java8.designpatterns.function;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
    public void accept(T t);

    default Consumer<T> andThen(Consumer<T> other) {
        // FAIL FAST: If we dont use below then a faulty consumer might get created with null value and fail at run time
        // which will be difficult to debug.
        Objects.requireNonNull(other);
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
