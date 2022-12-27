import java.util.ArrayList;

class Supervisor extends Employee {
    ArrayList<Employee> subordinates = new ArrayList<>();

    public Supervisor(int id, String name, BankAccount account, String department,
            double baseSalary, int sales, ArrayList<Employee> subordinates) {
        super(id, name, account, department, baseSalary, sales);
        this.subordinates = subordinates;

        int totalSales = sales;
        for (Employee e : subordinates) {
            totalSales += e.getSales();
        }

        this.setSales(totalSales);
    }
}