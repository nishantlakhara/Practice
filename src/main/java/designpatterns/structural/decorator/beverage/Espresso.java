package designpatterns.structural.decorator.beverage;

public class Espresso extends Beverage {
    @Override
    public String description() {
        return "Espresso";
    }

    @Override
    public int cost() {
        return 10;
    }
}
