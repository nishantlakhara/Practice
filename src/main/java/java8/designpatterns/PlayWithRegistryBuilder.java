package java8.designpatterns;

import java8.designpatterns.factory.Factory;
import java8.designpatterns.function.Consumer;
import java8.designpatterns.model.Circle;
import java8.designpatterns.model.Rectangle;
import java8.designpatterns.model.Shape;
import java8.designpatterns.model.Square;
import java8.designpatterns.registry.Builder;
import java8.designpatterns.registry.Registry;
import java8.designpatterns.shape.Triangle;

public class PlayWithRegistryBuilder {
    public static void main(String[] args) {
//        Builder<Rectangle> builder = null;
//        builder.register("rectangle", Rectangle::new);

        // OR

//        Consumer<Builder<Rectangle>> consumer =
//                b -> b.register("rectangle", Rectangle::new);
//
////        consumer.accept(null);
//        Registry registry = Registry.createRegistry(consumer);
//        Factory<Rectangle> rectangle = (Factory<Rectangle>) registry.buildShapeRegistry("rectangle");
//        Rectangle rectangle1 = rectangle.newInstance();
//        System.out.println(rectangle1);

        Consumer<Builder<Shape>> consumer =
                b -> b.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 =
                b -> b.register("triangle", Triangle::new);

        Consumer<Builder<Shape>> chainedConsumer = consumer.andThen(consumer2);
//        consumer.accept(null);
        Registry registry = Registry.createRegistry(chainedConsumer, s -> { throw new IllegalArgumentException("No such shape " + s);});

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeRegistry("rectangle");
        Rectangle rectangle1 = rectangleFactory.newInstance();
        System.out.println(rectangle1);

        Factory<Triangle> triangleFactory = (Factory<Triangle>) registry.buildShapeRegistry("triangle");
        Triangle triangle = triangleFactory.newInstance();
        System.out.println(triangle);

        Factory<Square> squareFactory = (Factory<Square>) registry.buildShapeRegistry("square");
        squareFactory.newInstance();  // Should throw Exception
    }
}
