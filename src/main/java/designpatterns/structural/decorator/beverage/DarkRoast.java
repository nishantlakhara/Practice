package designpatterns.structural.decorator.beverage;

public class DarkRoast extends Beverage {
    @Override
    public String description() {
        return "Dark Roast";
    }

    @Override
    public int cost() {
        return 10;
    }
}
