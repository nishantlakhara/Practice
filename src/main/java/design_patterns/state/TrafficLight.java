package design_patterns.state;

public interface TrafficLight {
    public void changeState(TrafficLightController trafficLightController);
    public void reportState();
}
