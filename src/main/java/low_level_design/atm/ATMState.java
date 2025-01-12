package low_level_design.atm;

public abstract class ATMState {
    public void insertCard() {
        throw new UnsupportedOperationException();
    }

    public void authenticate(Card card, int pin) {
        throw new UnsupportedOperationException();
    }

    public void selectOperation(TransactionType transactionType) {
        throw new UnsupportedOperationException();
    }

    public void cashWithdrawal(int amount) {
        throw new UnsupportedOperationException();
    }

    public void displayBalance() {
        throw new UnsupportedOperationException();
    }

    public void returnCard() {
        throw new UnsupportedOperationException();
    }

    public void exit() {
        throw new UnsupportedOperationException();
    }
}
