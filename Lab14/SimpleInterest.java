class SimpleInterest extends DepositInsurance {
    private double interestRate;

    public SimpleInterest(BankAccount account, double annuity, double interestRate, int expiration) {
        super(account, annuity, expiration);
        this.interestRate = interestRate;
    }

    public void interestPayment() {
        double total = getAnnuity() * (1 + interestRate);
        updateTotalValue(total);
    }

    public void yearEnd() {
        if (getCurrentYear() >= getExpiration()) {
            redemption();
        } else {
            if (getAccount().withdraw(getAnnuity())) {
                updateCurrentYear();
                interestPayment();
            } else {
                redemption(0.7);
                System.out.println("Deduction is not successful.");
            }
        }
    }
}
