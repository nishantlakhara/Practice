package javaexamples.java8.designpatterns.registry;

import javaexamples.java8.designpatterns.factory.Factory;
import javaexamples.java8.designpatterns.function.Consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
public interface Registry {

    Factory<? extends Shape> buildShapeRegistry(String shape);

    // 1.
//    static Registry createRegistry(Consumer<Builder<Rectangle>> consumer) {
//
//        Map<String, Factory<Rectangle>> map = new HashMap<>();
//        Builder<Rectangle> builder = (label, factory) -> map.put(label, factory);
//
//        // Would run above builder.register call which will put (label, factory) in map.
//        consumer.accept(builder);
//
//        System.out.println("map == " + map);
//
//        return shape -> map.get(shape);
//    }

    static Registry createRegistry(Consumer<Builder<Shape>> consumer) {

        Map<String, Factory<Shape>> map = new HashMap<>();
        Builder<Shape> builder = (label, factory) -> map.put(label, factory);

        // Would run above builder.register call which will put (label, factory) in map.
        consumer.accept(builder);

        System.out.println("map == " + map);

        // Second args is a supplier and thus a factory.
//        return shape -> map.getOrDefault(shape, () -> { throw new IllegalArgumentException("No such shape " + shape);});

        //OR
        Function<String, Factory<Shape>> errorFunction = s -> { throw new IllegalArgumentException("No such shape " + s); };

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }
}
*/


// Very secure, robust and performant. Even with reflection apis, you cannot get references.
public interface Registry<T> {

    Factory<? extends T> buildShapeRegistry(String shape);

    static <T> Registry<T> createRegistry(Consumer<Builder<T>> consumer, Function<String, Factory<T>> errorFunction) {
        Map<String, Factory<T>> map = new HashMap<>();
        Builder<T> builder = (label, factory) -> map.put(label, factory);
        consumer.accept(builder);
        return shape -> map.computeIfAbsent(shape, errorFunction);
    }

}
