package java8.designpatterns.factory;

import java8.designpatterns.function.Function;
import java8.designpatterns.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return this.get();
    }

    default List<T> create5() {
        return IntStream.range(0,5)
                .mapToObj(idx -> newInstance())
                .collect(Collectors.toList());
    }

    // 1.
//    static Factory<Circle> createFactory() {
//        return () -> new Circle();
//    }

    // 2.
//    static <T> Factory<T> createFactory(Supplier<T> supplier) {
//        return () -> supplier.get();
//    }

    // 3.
    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;         // Returns a supplier factory that returns this object.
                                        // Factory newInstance will return this same object on every call.
    }

    // 4.
//    static Factory<Circle> createFactory(Color color) {
//        // return () -> new Circle(color);
//        // can be re written as
//        Function<Color, Circle> constructor = c -> new Circle(c);
//        return () -> constructor.apply(color);
//    }

    // 5. First order function
    static <P, T> Factory<T> createFactory(Function<P, T> constructor, P color) {
        return () -> constructor.apply(color);
    }

}
