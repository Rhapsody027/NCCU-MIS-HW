import java.util.ArrayList;

public class OvertimeAnalyzer implements Analyzer {
    ArrayList<Employee> employees = new ArrayList<>();

    public void addE(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int count() {
        int size = 0;

        for (Employee employee : employees) {
            if (employee.getOverWork() != 0) {
                size++;
            }
        }

        return size;
    }

    public int sum() {
        int sum = 0;

        for (Employee employee : employees) {
            sum += employee.getOverWork();
        }

        return sum;
    }

    public double avg() {
        return (double) sum() / count();

    }

    public int max() {
        int max = 0;

        for (Employee employee : employees) {
            if (employee.getOverWork() > max) {
                max = employee.getOverWork();
            }
        }

        return max;
    }

    public void getInfo() {
        String info;
        info = String.format("<Over Work info>\n" +
                "          Employees:% 10d\n" +
                "        Total hours:% 10d\n" +
                "      Average hours:% 10.2f\n" +
                "          Max hours:% 10d", count(), sum(), avg(), max());

        System.out.println(info);
    }
}
