package designpatterns.behavorial.command;

public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("I do nothing.");
    }

    @Override
    public void undo() {
        System.out.println("I do nothing.");
    }
}
