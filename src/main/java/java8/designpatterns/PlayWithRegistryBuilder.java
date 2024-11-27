package java8.designpatterns;

import java8.designpatterns.factory.Factory;
import java8.designpatterns.function.Consumer;
import java8.designpatterns.model.Rectangle;
import java8.designpatterns.model.Shape;
import java8.designpatterns.registry.Builder;
import java8.designpatterns.registry.Registry;

public class PlayWithRegistryBuilder {
    public static void main(String[] args) {
//        Builder<Rectangle> builder = null;
//        builder.register("rectangle", Rectangle::new);

        // OR

        Consumer<Builder<Rectangle>> consumer =
                b -> b.register("rectangle", Rectangle::new);

//        consumer.accept(null);
        Registry registry = Registry.createRegistry(consumer);
        Factory<Rectangle> rectangle = (Factory<Rectangle>) registry.buildShapeRegistry("rectangle");
        Rectangle rectangle1 = rectangle.newInstance();
        System.out.println(rectangle1);
    }
}
