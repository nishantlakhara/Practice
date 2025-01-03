package designpatterns.structural.adapter.duck;

// Client can see only this interface.
// This is the target interface.
public interface Duck {
    public void quack();
    public void fly();
}
