package designsolid.liskov.vehiclewithengine;

public class BiCycle extends Vehicle {

    public Boolean hasEngine() {
        throw new UnsupportedOperationException("A BiCycle cannot have an engine");
    }
}
