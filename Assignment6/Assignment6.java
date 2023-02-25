import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Input company employees information");
            Company company = new Company(sc.next());

            int round1 = sc.nextInt();
            for (int i = 0; i < round1; i++) {
                String title = sc.next();
                String name = sc.next();
                int wage = sc.nextInt();
                Employee e;

                if (title.startsWith("s")) {
                    e = new Employee(title, name, wage);
                } else {
                    e = new Manager(title, name, wage, sc.nextDouble());
                }

                company.addE(e);
            }

            System.out.println("Input company employees information");

            int round2 = sc.nextInt();
            for (int i = 0; i < round2; i++) {
                company.addWork(sc.next(), sc.nextInt());
            }

            company.getInfo();
            company.callA();
        }
    }
}
