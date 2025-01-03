package designpatterns.behavorial.templatemethod;

public class Tea extends CaffeineBeverage {
    @Override
    public void addCondiments() {
        System.out.println("Add Lemon");
    }

    @Override
    public void brew() {
        System.out.println("Steeping the tea bag into water");
    }
}
