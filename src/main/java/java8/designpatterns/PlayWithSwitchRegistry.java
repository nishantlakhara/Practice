package java8.designpatterns;

import java8.designpatterns.factory.Factory;
import java8.designpatterns.model.Rectangle;
import java8.designpatterns.registry.SwitchRegistry;

public class PlayWithSwitchRegistry {
    public static void main(String[] args) {
        SwitchRegistry switchRegistry = new SwitchRegistry();
        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) switchRegistry.buildShapeFactory("rectangle");
        System.out.println("Rectangle: " + rectangleFactory.newInstance());
    }

}
