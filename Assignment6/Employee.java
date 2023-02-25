class Employee {
    private String name, title;
    private int wage, workDay = 0, overWork = 0;

    public Employee(String title, String name, int wage) {
        this.title = title;
        this.name = name;
        this.wage = wage;
    }

    public int getWage() {
        return wage;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getWorkDay() {
        return workDay;
    }

    public int getOverWork() {
        return overWork;
    }

    public void addWorkDay() {
        workDay++;
    }

    public void addOverWork(int overWork) {
        this.overWork += overWork;
    }

    public int payment() {
        double total = wage * workDay + wage / 8 * overWork * 1.5;

        return (int) total;
    }
}
