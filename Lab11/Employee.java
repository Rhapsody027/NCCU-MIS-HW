class Employee {
    int id, sales;
    double baseSalary, totalSalary;
    String name, department;
    BankAccount account;

    public Employee(int id, String name, BankAccount account, String department, double baseSalary, int sales) {
        this.id = id;
        this.sales = sales;
        this.baseSalary = baseSalary;
        this.name = name;
        this.department = department;
        this.account = account;
        this.totalSalary = 0;
    }

    public int getSales() {
        return sales;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void monthEnd() {
        double taxRate = 0.03, salesBonus = 500;
        totalSalary = (baseSalary + (sales * salesBonus)) * (1 - taxRate);
        account.deposit(totalSalary);
    }

    public String getInfo() {
        String info;

        info = "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Department: " + department + "\n" +
                "Total sales: " + sales + "\n" +
                "Total salary: " + totalSalary + "\n" +
                "Account amount: " + account.getBalance() + "\n";

        return info;
    }
}
