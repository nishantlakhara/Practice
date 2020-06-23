package design_patterns.state;

public class GreenLight implements TrafficLight {
    @Override
    public void changeState(TrafficLightController trafficLightController) {
        //DurationUtil.addSleepDuration(1000);
        trafficLightController.setState(new RedLight());
    }

    @Override
    public void reportState() {
        System.out.println("Green Light");
    }
}
