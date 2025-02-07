package designpatterns.creational.singleton;

public class B extends A {

    private B() {
        super(B.class);
    }
}