package low_level_design.atm;

public class HasCard extends ATMState {
    private ATMMachine atmMachine;
    private CardService cardService;

    public HasCard(ATMMachine atmMachine, CardService cardService) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void authenticate(Card card, int pin) {
        Integer pinFromCard = cardService.getPinFromCard(card);
        if(pinFromCard == null || pin != pinFromCard) {
            System.out.println("Invalid Card or Invalid PIN Number");
            exit();
        } else {
            atmMachine.setState(new SelectionState(atmMachine, cardService));
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
