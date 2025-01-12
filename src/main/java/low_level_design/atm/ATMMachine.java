package low_level_design.atm;

public class ATMMachine {

    private ATMState state;

    public ATMState getState() {
        return state;
    }

    public void setState(ATMState state) {
        this.state = state;
    }


}
