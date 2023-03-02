public class BankCard extends Card {
    protected int expYear;

    public BankCard(String name, int year) {
        super(name);
        this.expYear = year;
    }

    public void replace(int year) {
        if (year <= expYear) {
            System.out.println("Your card has not expired.");
        } else {
            this.expYear = year + 1;
        }
    }

    public void getInfo() {
        String info;
        info = String.format("<BANK CARD INFO>\n" + "Name: %s\n" + "Expire year: %d\n", super.getName(), expYear);
        System.out.println(info);
    }
}
