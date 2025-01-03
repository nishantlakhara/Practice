package designpatterns.behavorial.command;

public class SimpleMain {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();

        remoteControl.setCommand(new LightOnCommand(new Light("Living Room")));
        remoteControl.buttonWasPressed();

        remoteControl.setCommand(new GarageDoorOpenCommand(new GarageDoor()));
        remoteControl.buttonWasPressed();
    }
}
