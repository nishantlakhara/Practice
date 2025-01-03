package designpatterns.behavorial.strategy.quack;

import designpatterns.behavorial.strategy.quack.QuackBehavior;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
