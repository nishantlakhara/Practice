package java8.designpatterns.registry;

import java8.designpatterns.factory.Factory;
import java8.designpatterns.model.Rectangle;
import java8.designpatterns.model.Shape;
import java8.designpatterns.model.Square;
import java8.designpatterns.shape.Triangle;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape) {
        switch(shape) {
            case "square" : return () -> new Square();
            case "triangle" : return () -> new Triangle();
            case "rectangle" : return () -> new Rectangle();
            default:
                throw new IllegalArgumentException("No such shape defined.");
        }
    }
}
