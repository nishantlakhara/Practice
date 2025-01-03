package designpatterns.behavorial.strategy;

import designpatterns.behavorial.strategy.fly.FlyWithWings;
import designpatterns.behavorial.strategy.quack.Quack;

public class Main {
    public static void main(String[] args) {
        Duck duck = new MallardDuck(new FlyWithWings(), new Quack());
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}
