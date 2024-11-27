package java8.designpatterns.registry;

import java8.designpatterns.factory.Factory;
import java8.designpatterns.function.Consumer;
import java8.designpatterns.model.Rectangle;
import java8.designpatterns.model.Shape;

import java.util.HashMap;
import java.util.Map;

public interface Registry {

    Factory<? extends Shape> buildShapeRegistry(String shape);

    static Registry createRegistry(Consumer<Builder<Rectangle>> consumer) {

        Map<String, Factory<Rectangle>> map = new HashMap<>();
        Builder<Rectangle> builder = (label, factory) -> map.put(label, factory);

        // Would run above builder.register call which will put (label, factory) in map.
        consumer.accept(builder);

        System.out.println("map == " + map);

        return shape -> map.get(shape);
    }
}
