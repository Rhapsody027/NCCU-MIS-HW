import java.util.ArrayList;

public class Bonus2 {
    public static void main(String[] args) throws Exception {
        SalaryEmployee e1 = new SalaryEmployee("John", 2016, 45000);
        SalaryEmployee e2 = new SalaryEmployee("Peter", 2020, 55000);
        HourlyEmployee e3 = new HourlyEmployee("Jason", 2017, 400, 80);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        for (Employee employee : employees) {
            System.out.println(presentResult(employee, 2021));
        }
        System.out.println();
        for (Employee employee : employees) {
            System.out.println(presentResult(employee, 2022));
        }
    }

    public static String presentResult(Employee emp, int year) {
        String info;
        emp.setSeniority(year);
        emp.setSalary();
        info = String.format("%s's salary for %d: %.0f", emp.getName(), year, emp.getSalary());

        return info;
    }
}
