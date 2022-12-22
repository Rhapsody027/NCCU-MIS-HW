public class CheckingAccount extends BankAccount {
    private int transCount;

    public CheckingAccount(int amount, int ID) {
        this.setBalance(amount);
        this.setID(ID);
    }

    public void deposit(double amount) {
        transCount += 1;
        super.deposit(amount);
    }

    public void withdraw(double amount) {
        transCount += 1;
        super.withdraw(amount);
    }

    public void monthEnd() {
        double commissionFee = 5;

        if (transCount > 3) {
            balance -= commissionFee;
        }

        transCount = 0;
    }

}
