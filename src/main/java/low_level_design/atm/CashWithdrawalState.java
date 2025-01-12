package low_level_design.atm;

public class CashWithdrawalState extends ATMState {
    private ATMMachine atmMachine;

    public CashWithdrawalState(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
        showOperations();
    }

    private void showOperations() {
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }

    @Override
    public void cashWithdrawal(int amount) {
        System.out.println("Withdrawing Cash " + amount);

    }
}
