package low_level_design.atm;

public class CheckBalanceState extends ATMState {

    private ATMMachine atmMachine;

    public CheckBalanceState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
}
