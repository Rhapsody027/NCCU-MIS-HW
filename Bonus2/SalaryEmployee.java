class SalaryEmployee extends Employee {
    private double avgSalary, raiseRate;

    public SalaryEmployee(String name, int onboardYear, double avgSalary) {
        super(name, onboardYear);
        this.avgSalary = avgSalary;
    }

    public void setSalary() {
        setRaiseRate();
        this.salary = raiseRate * avgSalary;
    }

    public void setRaiseRate() {
        this.raiseRate = (1 + (this.seniority / 100.0));
    }
}