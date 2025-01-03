package designpatterns.behavorial.state.trafficlight;

public class RedLight implements TrafficLight {
    @Override
    public void changeState(TrafficLightController trafficLightController) {
        //DurationUtil.addSleepDuration(1000);
        trafficLightController.setState(new YellowLight());
    }

    @Override
    public void reportState() {
        System.out.println("Red Light");
    }
}
