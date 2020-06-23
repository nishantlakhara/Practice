package design_patterns.state;

public class YellowLight implements TrafficLight {
    @Override
    public void changeState(TrafficLightController trafficLightController) {
        //DurationUtil.addSleepDuration(1000);
        trafficLightController.setState(new GreenLight());
    }

    @Override
    public void reportState() {
        System.out.println("Yellow Light");
    }
}
