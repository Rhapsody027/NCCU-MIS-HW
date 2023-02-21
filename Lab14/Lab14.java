import java.util.ArrayList;

public class Lab14 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(109306500);
        account1.deposit(1000000);
        System.out.print(account1.getInfo());

        double annuity = 10000;
        int expiration = 3;

        SimpleInterest insurance1 = new SimpleInterest(account1, annuity, 0.03, expiration);
        CompoundInterest insurance2 = new CompoundInterest(account1, annuity, expiration);
        insurance2.addInterestRate(0.02);
        insurance2.addInterestRate(0.03);
        insurance2.addInterestRate(0.04);

        ArrayList<DepositInsurance> insurances = new ArrayList<DepositInsurance>();
        insurances.add(insurance1);
        insurances.add(insurance2);

        for (DepositInsurance i : insurances) {
            if (i instanceof SimpleInterest) {
                System.out.println("\n<<Simple Interest Insurance>>");
                System.out.println("----------------------------------");
            } else if (i instanceof CompoundInterest) {
                System.out.println("\n<<Compound Interest Insurance>>");
                System.out.println("----------------------------------");
            }

            while (i.getCurrentYear() < i.getExpiration()) {
                i.yearEnd();
                System.out.println(i.getInfo());
                System.out.println("----------------------------------");
            }
        }
    }
}