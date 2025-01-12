package low_level_design.atm;

public class SelectionState extends ATMState {
    private ATMMachine atmMachine;
    private CardService cardService;

    public SelectionState(ATMMachine atmMachine, CardService cardService) {
        this.atmMachine = atmMachine;
        this.cardService = cardService;
    }

    @Override
    public void selectOperation(TransactionType transactionType) {
        switch (transactionType) {

            case CASH_WITHDRAWAL:
                atmMachine.setState(new CashWithdrawalState(atmMachine));
                break;
            case DISPLAY_BALANCE:
                atmMachine.setState(new CheckBalanceState(atmMachine));
                break;
            default: {
                System.out.println("Invalid Option");
                exit();
            }
        }
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect ypur card.");
        atmMachine.setState(new IdleState(atmMachine, cardService));
    }

    @Override
    public void exit() {
        System.out.println("Card is dispensed out.");
        atmMachine.setState(new IdleState(atmMachine, cardService));
    }
}
