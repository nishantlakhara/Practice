package java8.designpatterns.factory;

import java8.designpatterns.model.Circle;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
public interface CircleFactory extends Supplier<Circle> {

    default Circle newInstance() {
        return this.get();
    }

    default List<Circle> create5Circles() {
        return IntStream.range(0,5)
                .mapToObj(idx -> newInstance())
                .collect(Collectors.toList());
    }
}
