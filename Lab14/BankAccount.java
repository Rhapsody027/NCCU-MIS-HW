public class BankAccount {
    private int accountID;
    private double balance, interestRate;

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(int accountID) {
        this.accountID = accountID;
        this.balance = 0;
        this.interestRate = 0.001;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public String getInfo() {
        return String.format("Account ID: %d\n" +
                "Balance: %.2f\n", accountID, balance);
    }
}