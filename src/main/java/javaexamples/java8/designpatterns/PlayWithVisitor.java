package javaexamples.java8.designpatterns;

import javaexamples.java8.designpatterns.model.Engine;
import javaexamples.java8.designpatterns.visitor.Visitor;
import javaexamples.java8.designpatterns.visitor.VisitorBuilder;
import javaexamples.java8.designpatterns.model.Body;
import javaexamples.java8.designpatterns.model.Car;
//import java.java8.designpatterns.visitor.VisitorOld;

import java.util.function.Consumer;

public class PlayWithVisitor {
    public static void main(String[] args) {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();


        // 1.
//        Consumer<VisitorBuilder<String>> consumer =
//                Visitor.<String>forType(Car.class).execute(c -> "Visiting car: " + c);
//
//        Visitor<String> visitor = Visitor.of(consumer);
//
//        String visit = visitor.visit(car);
//        System.out.println(visit);

        // 2.
//        Consumer<VisitorBuilder<String>> consumer =
//                VisitorOld.<String>forType(Car.class).execute(c -> "Visiting car: " + c)
//                        .forType(Engine.class).execute(e -> "Visiting engine: " + e)
//                        .forType(Body.class).execute(b -> "Visiting body: " + b);
//
//
//
//
//        VisitorOld<String> visitor = VisitorOld.of(consumer);
//
//        String carVisit = visitor.visit(car);
//        System.out.println(carVisit);
//
//        String engineVisit = visitor.visit(engine);
//        System.out.println(engineVisit);
//
//        String bodyVisit = visitor.visit(body);
//        System.out.println(bodyVisit);


        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car: " + c)
                        .forType(Engine.class).execute(e -> "Visiting engine: " + e)
                        .forType(Body.class).execute(b -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        String carVisit = visitor.visit(car);
        System.out.println(carVisit);

        String engineVisit = visitor.visit(engine);
        System.out.println(engineVisit);

        String bodyVisit = visitor.visit(body);
        System.out.println(bodyVisit);
    }
}
