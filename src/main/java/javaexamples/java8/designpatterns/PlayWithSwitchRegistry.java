package javaexamples.java8.designpatterns;

import javaexamples.java8.designpatterns.factory.Factory;
import javaexamples.java8.designpatterns.model.Rectangle;
import javaexamples.java8.designpatterns.registry.SwitchRegistry;

public class PlayWithSwitchRegistry {
    public static void main(String[] args) {
        SwitchRegistry switchRegistry = new SwitchRegistry();
        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) switchRegistry.buildShapeFactory("rectangle");
        System.out.println("Rectangle: " + rectangleFactory.newInstance());
    }

}
