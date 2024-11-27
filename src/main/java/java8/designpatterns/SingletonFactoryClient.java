package java8.designpatterns;

import java.awt.Color;
import java8.designpatterns.factory.Factory;
import java8.designpatterns.model.Circle;

public class SingletonFactoryClient {

    public static void main(String[] args) {
        // Define a color for the circle
        Color color = Color.RED;
        
        // Use the Factory to create a singleton Circle instance
        Factory<Circle> circleFactory = Factory.createFactory(() -> new Circle(color));

        // Get the singleton instance of Circle
        Circle circle1 = circleFactory.newInstance();
        Circle circle2 = circleFactory.newInstance();

        // Verify that both references point to the same instance
        System.out.println("Are both circles the same instance? " + (circle1 == circle2));  // Should print true
        System.out.println("Circle 1: " + circle1);
        System.out.println("Circle 2: " + circle2);
    }
}
