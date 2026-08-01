package low_level_design.atm;

public class Main {

    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();
        IdleState state = new IdleState(atmMachine, new CardService());
        atmMachine.setState(state);

        atmMachine.getState().insertCard();
        atmMachine.getState().authenticate(new Card(1122334455667790l), 1234);
        atmMachine.getState().selectOperation(TransactionType.CASH_WITHDRAWAL);
        atmMachine.getState().cashWithdrawal(3000);
    }
}
