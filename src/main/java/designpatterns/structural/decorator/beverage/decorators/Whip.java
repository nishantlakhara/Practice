package designpatterns.structural.decorator.beverage.decorators;

import designpatterns.structural.decorator.beverage.Beverage;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return "Whip " + beverage.description();
    }

    @Override
    public int cost() {
        return 1 + beverage.cost();
    }
}
