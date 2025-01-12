package low_level_design.atm;

public enum TransactionType {
    CASH_WITHDRAWAL,
    CASH_DEPOSIT,
    DISPLAY_BALANCE;

    public static void showAllTransactionTypes() {
        for(TransactionType type: TransactionType.values()){
            System.out.println(type.name());
        }
    }
}
