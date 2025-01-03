package designpatterns.behavorial.state.trafficlight;

public interface TrafficLight {
    public void changeState(TrafficLightController trafficLightController);
    public void reportState();
}
