package designpatterns.behavorial.strategy.quack;

import designpatterns.behavorial.strategy.quack.QuackBehavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
