package abstractfactorypattern;

public enum BankType {
    HDFC("HDFC"), 
    ICICI("ICICI"), 
    AXIS("AXIS");

    private final String bankType;

    BankType(String bankType) {
        this.bankType = bankType;
    }

    public String toString () {
        return bankType;
    }
}
