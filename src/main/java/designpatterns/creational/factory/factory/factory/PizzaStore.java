package designpatterns.creational.factory.factory.factory;



public abstract class PizzaStore {

    // Template to create pizza and do operations on it.
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);

//        pizza.prepare();
//        pizza.bake();
//        pizza.cut();
//        pizza.box();

        return pizza;
    }

    // Abstract factory method that return the factory
    public abstract Pizza createPizza(String type);

}
