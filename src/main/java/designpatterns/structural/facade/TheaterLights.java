package designpatterns.structural.facade;

public class TheaterLights {
    public void dim(int i) {
        System.out.println("Dimming the theatre lights to intensity = " + i);
    }

    public void on() {
        System.out.println("Theatre lights are turned on now");
    }
}
