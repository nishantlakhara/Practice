package designpatterns.structural.decorator.beverage;

import designpatterns.structural.decorator.beverage.decorators.Mocha;
import designpatterns.structural.decorator.beverage.decorators.Whip;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println("Beverage : " + beverage.description() + " costs " + beverage.cost());

        Beverage beverage1 = new Mocha(new Mocha(new Whip(new DarkRoast())));
        System.out.println("Beverage : " + beverage1.description() + " costs " + beverage1.cost());

    }
}
