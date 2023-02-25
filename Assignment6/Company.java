import java.util.ArrayList;

class Company {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addE(Employee employee) {
        employees.add(employee);
    }

    public Employee find(String name) {
        for (Employee employee : employees) {
            if (name.equals(employee.getName())) {
                return employee;
            }
        }

        System.out.println("The employee is not found.");
        return null;
    }

    public void addWork(String name, int hour) {
        Employee e = find(name);

        if (e != null) {
            e.addWorkDay();

            if (hour > 8) {
                e.addOverWork(hour - 8);
            }
        }
    }

    public void callA() {
        WageAnalyzer wa = new WageAnalyzer();
        OvertimeAnalyzer oa = new OvertimeAnalyzer();

        wa.addE(employees);
        oa.addE(employees);
        wa.getInfo();
        oa.getInfo();
    }

    public void getInfo() {
        String info = "<Company: " + name + ">\n" +
                "      Name   WorkDay  Overtime      Wage     Title\n";

        for (Employee e : employees) {
            info += String.format("%10s" + "% 10d" + "% 10d" + "% 10d" + "%10s\n",
                    e.getName(), e.getWorkDay(), e.getOverWork(), e.payment(), e.getTitle());
        }

        System.out.println(info);
    }
}