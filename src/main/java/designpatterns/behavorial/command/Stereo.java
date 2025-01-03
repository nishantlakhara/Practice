package designpatterns.behavorial.command;

public class Stereo {
    public void on() {
        System.out.println("Setting Stereo On");
    }

    public void setCD() {
        System.out.println("Setting CD on Stereo");
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume on stereo " + volume);
    }

    public void off() {
        System.out.println("Setting stereo Off");
    }
}
