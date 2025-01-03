package designpatterns.behavorial.strategy.fly;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can fly because I have wings.");
    }
}
