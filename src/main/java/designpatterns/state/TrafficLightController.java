package designpatterns.state;

public class TrafficLightController {
    TrafficLight trafficLight;

    public void setState(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void changeState() {
        trafficLight.changeState(this);
    }

    public void reportState() {
        trafficLight.reportState();
    }
}
