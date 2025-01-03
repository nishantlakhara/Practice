package designpatterns.behavorial.command;

public class CeilingFanOnCommand implements Command {
    private CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }


    @Override
    public void execute() {
        this.ceilingFan.turnOn();
    }

    @Override
    public void undo() {
        ceilingFan.turnOff();
    }
}
