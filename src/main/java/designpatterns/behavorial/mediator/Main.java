package designpatterns.behavorial.mediator;

import designpatterns.behavorial.state.trafficlight.DurationUtil;

public class Main {
    public static void main(String[] args) {
        LightMediator mediator = new LightMediator();
        Light redLight = new Light("Red", mediator);
        Light yellowLight = new Light("Yellow", mediator);
        Light greenLight = new Light("Green", mediator);

        while(true) {
            redLight.turnOn();
            DurationUtil.addSleepDuration(1000);
            System.out.println("===========================");
            yellowLight.turnOn();
            DurationUtil.addSleepDuration(1000);
            System.out.println("===========================");
            greenLight.turnOn();
            DurationUtil.addSleepDuration(1000);
            System.out.println("===========================");
        }
    }
}
