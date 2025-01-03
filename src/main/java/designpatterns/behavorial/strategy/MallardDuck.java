package designpatterns.behavorial.strategy;

import designpatterns.behavorial.strategy.fly.FlyBehavior;
import designpatterns.behavorial.strategy.quack.QuackBehavior;

public class MallardDuck extends Duck {

    public MallardDuck() {
    }

    public MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.setFlyBehavior(flyBehavior);
        this.setQuackBehavior(quackBehavior);
    }

    @Override
    public void display() {
        System.out.println("I am a Mallard Duck");
    }
}
