package low_level_design.atm;

public class IdleState extends ATMState {
    private ATMMachine atmMachine;
    private CardService cardService;

    public IdleState(ATMMachine atmMachine, CardService cardService) {
        this.atmMachine = atmMachine;
        this.cardService = cardService;
    }

    public void insertCard() {
        System.out.println("Card is inserted into ATM Machine");
        atmMachine.setState(new HasCard(atmMachine, cardService));
    }
}
