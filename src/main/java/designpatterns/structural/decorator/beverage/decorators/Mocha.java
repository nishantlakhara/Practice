package designpatterns.structural.decorator.beverage.decorators;

import designpatterns.structural.decorator.beverage.Beverage;

public class Mocha extends CondimentDecorator {


    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String description() {
        return "Mocha " + beverage.description();
    }

    @Override
    public int cost() {
        return 2 + beverage.cost();
    }
}
