package designsolid.liskov.flyablebird;

public class Ostrich extends Bird {

    @Override
    public void fly() {
        System.out.println("I cannot fly");
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}
