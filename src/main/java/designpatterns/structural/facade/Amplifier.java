package designpatterns.structural.facade;

public class Amplifier {
    public void on() {
        System.out.println("Turning amplifier on");
    }

    public void setStreamingPlayer(StreamingPlayer player) {
        System.out.println("Setting Streaming player to " + player);
    }

    public void setSurroundSound() {
        System.out.println("Setting sound mode to surround sound");
    }


    public void setVolume(int i) {
        System.out.println("Setting volume to " + i);
    }

    public void off() {
        System.out.println("Turned amplifier off.");
    }
}
