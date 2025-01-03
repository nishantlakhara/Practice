package designpatterns.creational.factory.factory.factory;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        PizzaStore pizzaStore1 = new ChicagoStypePizzaStore();

        pizzaStore.orderPizza("pepperoni");
        pizzaStore1.orderPizza("pepperoni");
    }
}
