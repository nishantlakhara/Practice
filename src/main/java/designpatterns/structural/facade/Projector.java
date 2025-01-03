package designpatterns.structural.facade;

public class Projector {
    public void on() {
        System.out.println("Projector is turned on.");
    }

    public void wideScreenMode() {
        System.out.println("setting projector to wide screen mode");
    }

    public void off() {
        System.out.println("Project is turned off.");
    }
}
