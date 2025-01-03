package designpatterns.structural.facade;

public class PopcornPopper {
    public void on() {
        System.out.println("Popcorn popper is turned on");
    }

    public void pop() {
        System.out.println("Popcorn popper is popping");
    }

    public void off() {
        System.out.println("Popcorn popper is shutting down.");
    }
}
