package design_patterns.state;

public class Main {
    public static void main(String[] args) {
        TrafficLightController trafficLightController = new TrafficLightController();
        trafficLightController.setState(new RedLight());

        while(true) {
            trafficLightController.reportState();
            trafficLightController.changeState();
            DurationUtil.addSleepDuration(1000);
        }
    }
}
