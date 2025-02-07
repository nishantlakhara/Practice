package javaexamples.java8.designpatterns;

import javaexamples.java8.designpatterns.factory.CircleFactory;
import javaexamples.java8.designpatterns.factory.Factory;
import javaexamples.java8.designpatterns.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;

public class PlayWithFactory {
    public static void main(String[] args) {
        Supplier<Circle> factory = () -> new Circle();

        Circle circle = factory.get();
        System.out.println("circle = " + circle);

        // Above doesnt use newInstance method. Use your own name.
        // Create a CircleFactory.
        CircleFactory circleFactory = () -> new Circle();

        Circle circle1 = circleFactory.newInstance();
        System.out.println("circle1 = " + circle1);

        List<Circle> list = circleFactory.create5Circles();
        System.out.println("list1 = " + list);

        // Generic factory
        Factory<Circle> factory1 = () -> new Circle();

        Circle circle2 = factory1.newInstance();
        System.out.println("circle2 = " + circle2);

        List<Circle> list2 = factory1.create5();
        System.out.println("list2 = " + list2);


        // Generic factory
//        Factory<Circle> factory2 = Factory.createFactory(Color.RED);
//
//        Circle circle3 = factory2.newInstance();
//        System.out.println("circle3 = " + circle3);
//
//        List<Circle> list3 = factory2.create5();
//        System.out.println("list3 = " + list3);

        Factory factory3 = Factory.createFactory(Circle::new);
        Factory factory4 = Factory.createFactory(Circle::new, Color.RED);
        Factory factory5 = Factory.createFactory(() -> new Circle());
        Factory factory6 = Factory.createFactory((c) -> new Circle(c), Color.RED);


    }
}
