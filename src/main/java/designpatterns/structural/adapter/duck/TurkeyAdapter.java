package designpatterns.structural.adapter.duck;

// Duck is the target interface. Client can see only this interface so we are creating an adapter.
public class TurkeyAdapter implements Duck {

    // Holds a turkey object.
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i=0; i<5; i++)
            turkey.fly();
    }
}
