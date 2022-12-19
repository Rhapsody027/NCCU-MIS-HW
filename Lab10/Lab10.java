import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) throws Exception {
        BankAccount accountA = new SavingsAccount(8000, 306049001, 1);
        BankAccount accountB = new SavingsAccount(1000, 306049011, 2);
        BankAccount accountC = new CheckingAccount(9000, 306016033);
        BankAccount accountD = new CheckingAccount(3000, 306016041);

        BankAccount[] accounts = { accountA, accountB, accountC, accountD };
        Scanner sc = new Scanner(System.in);
        String mode = "";

        while (!mode.equals("Q")) {
            System.out.print("D)Deposit W)Withdraw M)Month end Q)Quit:");
            mode = sc.next();

            if (mode.equals("D") || mode.equals("W")) {
                BankAccount account = null;

                System.out.print("Enter your account number:");
                int id = sc.nextInt();
                System.out.print("Enter transaction amount:");
                double amount = sc.nextDouble();

                for (BankAccount a : accounts) {
                    if (id == a.getId()) {
                        account = a;
                    }
                }

                if (account == null) {
                    System.out.println("Corresponding account cannot be found.");
                    continue;
                } else if (mode.equals("D")) {
                    account.deposit(amount);
                } else if (mode.equals("W")) {
                    account.withdraw(amount);
                }

                System.out.printf("Balance: %.1f%n", account.getBalance());

            } else if (mode.equals("M")) {
                for (int i = 0; i < 4; i++) {
                    accounts[i].monthEnd();
                    System.out.printf("%d %.1f%n", i, accounts[i].getBalance());
                }
            }
        }

        sc.close();
    }
}
