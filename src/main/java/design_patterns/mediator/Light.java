package design_patterns.mediator;

public class Light {
    private String color;
    private LightMediator mediator;
    private State currentState;

    public void turnOff() {
        currentState = State.OFF;
        System.out.println(color + " light is " + currentState);
    }

    private enum State {ON, OFF};

    public Light(String color, LightMediator mediator) {
        this.color = color;
        this.mediator = mediator;
        mediator.register(this);
    }

    public void turnOn() {
        currentState = State.ON;
        System.out.println(color + " light is " + currentState);
        mediator.notifyStateChange(this);
    }
}
