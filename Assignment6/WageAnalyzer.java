import java.util.ArrayList;

class WageAnalyzer implements Analyzer {
    ArrayList<Employee> employees = new ArrayList<>();

    public void addE(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int count() {
        return employees.size();
    }

    public int sum() {
        int sum = 0;

        for (Employee employee : employees) {
            sum += employee.payment();
        }

        return sum;
    }

    public double avg() {
        return (double) sum() / count();
    }

    public int max() {
        int max = 0;

        for (Employee employee : employees) {
            if (employee.payment() > max) {
                max = employee.payment();
            }
        }

        return max;
    }

    public void getInfo() {
        String info;
        info = String.format("<Wage info>\n" +
                "          Employees:% 10d\n" +
                "      Total payment:% 10d\n" +
                "    Average payment:% 10.2f\n" +
                "        Max payment:% 10d\n", count(), sum(), avg(), max());

        System.out.println(info);
    }
}