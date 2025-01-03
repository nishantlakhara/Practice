package designpatterns.behavorial.templatemethod;

public abstract class CaffeineBeverage {

    public final void prepareRecipe() {
        boilWater();

        brew();

        pourInCup();

        addCondiments();
    }

    public abstract void addCondiments();

    public abstract void brew();

    public void pourInCup() {
        // Implementation
        System.out.println("Pouring into cup.");
    }

    public void boilWater() {
        // Implementation
        System.out.println("Boiling water");
    }
}
