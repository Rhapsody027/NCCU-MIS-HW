class HourlyEmployee extends Employee {
    private double wageHour, workingHours;

    public HourlyEmployee(String name, int onboardYear, double wageHour, double workingHours) {
        super(name, onboardYear);
        this.wageHour = wageHour;
        this.workingHours = workingHours;
    }

    public void setSalary() {
        this.salary = wageHour * workingHours;
    }
}