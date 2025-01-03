package designpatterns.behavorial.command;

public class CeilingFanOffCommand implements Command {

    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.turnOff();
    }

    @Override
    public void undo() {
        ceilingFan.turnOn();
    }
}
