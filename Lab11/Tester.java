import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(102603901, 1000);
        BankAccount account2 = new BankAccount(102603902, 1500);
        BankAccount account3 = new BankAccount(102603903, 1400);
        BankAccount account4 = new BankAccount(102603904, 1800);

        Employee Alex = new Employee(109306201, "Alex", account1, "Sales Dept.", 35000, 50);
        Employee Lily = new Employee(109306203, "Lily", account2, "Sales Dept.", 27500, 8);
        Employee Tony = new Employee(109306204, "Tony", account3, "Marketing Dept.", 40000, 30);

        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(Alex);
        employees.add(Lily);
        employees.add(Tony);

        ArrayList<Employee> salesSubOrdinates = new ArrayList<Employee>();
        for (Employee e : employees) {
            if (e.getDepartment() == "Sales Dept.") {
                salesSubOrdinates.add(e);
            }
        }

        Employee Bob = new Supervisor(110306202, "Bob", account4, "Sales Dept.", 45000, 10,
                salesSubOrdinates);
        employees.add(Bob);

        for (Employee e : employees) {
            e.monthEnd();
            System.out.print(e.getInfo());
            if (employees.indexOf(e) != employees.size() - 1) {
                System.out.println("\n");
            }
        }
    }
}