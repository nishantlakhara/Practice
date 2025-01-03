package designpatterns.structural.facade;

public class StreamingPlayer {
    public void on() {
        System.out.println("Turning the player on");
    }

    public void play(String movie) {
        System.out.println("Movie started");
    }

    public void stop() {
        System.out.println("Turned the movie off.");
    }

    public void off() {
        System.out.println("Turned the player off.");
    }
}
