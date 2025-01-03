package designpatterns.behavorial.command;

import weird.C;

public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        remoteControl.setCommand(0, new LightOnCommand(livingRoomLight), new LightOffCommand(livingRoomLight));

        Light kitchenLight = new Light("Kitchen");
        remoteControl.setCommand(1, new LightOnCommand(kitchenLight), new LightOffCommand(kitchenLight));

        CeilingFan ceilingFan = new CeilingFan();
        remoteControl.setCommand(2, new CeilingFanOnCommand(ceilingFan), new CeilingFanOffCommand(ceilingFan));

        Stereo stereo = new Stereo();
        remoteControl.setCommand(3, new StereoOnWithCDCommand(stereo), new StereoOffWithCDCommand(stereo));

        Command[] commands = new Command[] {
                new LightOnCommand(new Light("Room1")),
                new LightOnCommand(new Light("Room2"))
        };
        remoteControl.setOnCommand(5, new MacroCommand(commands));

        remoteControl.onButtonWasPushed(0);
        remoteControl.undoCommandWasPressed();
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoCommandWasPressed();

        remoteControl.onButtonWasPushed(1);
        remoteControl.undoCommandWasPressed();
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoCommandWasPressed();

        remoteControl.onButtonWasPushed(2);
        remoteControl.undoCommandWasPressed();
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoCommandWasPressed();

        remoteControl.onButtonWasPushed(3);
        remoteControl.undoCommandWasPressed();
        remoteControl.offButtonWasPushed(3);
        remoteControl.undoCommandWasPressed();

        remoteControl.onButtonWasPushed(5);
        remoteControl.undoCommandWasPressed();
    }
}
