public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(int amount, int ID, double interestRate) {
        this.setID(ID);
        this.setBalance(amount);
        this.interestRate = interestRate * 0.01;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void monthEnd() {
        balance *= 1 + interestRate;
    }
}
