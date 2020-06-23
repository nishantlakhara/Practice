package designpatterns.state;

public interface TrafficLight {
    public void changeState(TrafficLightController trafficLightController);
    public void reportState();
}
