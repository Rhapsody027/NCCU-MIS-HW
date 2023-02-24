import java.util.ArrayList;

class CompoundInterest extends DepositInsurance {
    private ArrayList<Double> interestRate;

    public CompoundInterest(BankAccount account, double annuity, int expiration) {
        super(account, annuity, expiration);
        this.interestRate = new ArrayList<>();
    }

    public void addInterestRate(double rate) {
        interestRate.add(rate);
    }

    public void interestPayment() {
        double total = getAnnuity() * (1 + interestRate.get(getCurrentYear() - 1));
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
