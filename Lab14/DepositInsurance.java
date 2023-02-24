abstract class DepositInsurance {
    private BankAccount account;
    private double totalValue, annuity;
    private int expiration, currentYear;

    public DepositInsurance(BankAccount account, double annuity, int expiration) {
        this.account = account;
        this.annuity = annuity;
        this.expiration = expiration;
        this.totalValue = 0;
        this.currentYear = 0;
    }

    public BankAccount getAccount() {
        return account;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public double getAnnuity() {
        return annuity;
    }

    public int getExpiration() {
        return expiration;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void updateCurrentYear() {
        currentYear++;
    }

    public void updateAnnuity(double amount) {
        annuity += amount;
    }

    public void updateTotalValue(double amount) {
        totalValue += amount;
    }

    public void redemption() {
        account.deposit(totalValue);
    }

    public void redemption(double redemptionRate) {
        totalValue -= redemptionRate;
        account.deposit(totalValue);
    }

    abstract public void yearEnd();

    public String getInfo() {
        return String.format("Design Bank Account: %d\n" +
                "Current Total Value: %.2f\n" +
                "Elapsed Years: %d",
                account.getAccountID(), totalValue, currentYear);
    }
}
