class Manager extends Employee {
    private double bonusRate;

    public Manager(String title, String name, int wage, double bonusRate) {
        super(title, name, wage);
        this.bonusRate = bonusRate;
    }

    public int payment() {
        double total = super.payment() * bonusRate;

        return (int) total;
    }
}