abstract class Employee {
    protected String name;
    protected int onboardYear, seniority;
    protected double salary;

    Employee(String name, int onboardYear) {
        this.name = name;
        this.onboardYear = onboardYear;
    }

    public String getName() {
        return name;
    }

    public int getOnboardYear() {
        return onboardYear;
    }

    public int getSeniority() {
        return seniority;
    }

    public double getSalary() {
        return salary;
    }

    public void setSeniority(int year) {
        this.seniority = year - onboardYear;
    }

    abstract void setSalary();
}
