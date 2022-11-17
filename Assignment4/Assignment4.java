public class Assignment4 {
    public static void main(String[] args) throws Exception {
        Student stu1 = new Student(109306100, "Allen", 3);
        Student stu2 = new Student(109306101, "Bob");
        Course c1 = new Course(306001, "OOPI-1", 2, 5);
        Course c2 = new Course(306011, "OOPI-2", 2, 20);
        Course c3 = new Course(306021, "DBMS", 3, 10);

        stu1.enroll(c1);
        // test student maxCredits
        stu1.enroll(c2);

        stu2.enroll(c1);
        stu2.enroll(c2);
        stu2.enroll(c3);
        stu2.drop(306001);
        stu2.drop(c2);
        stu2.enroll(c2);

        // test course capacity
        for (int i = 0; i < 5; i++) {
            new Student(i, "robot").enroll(c1);
        }

        // test course not found
        stu1.drop(c3);

        System.out.println("-".repeat(40));
        System.out.println(stu1.getInfo());
        System.out.println("-".repeat(40));
        System.out.println(stu2.getInfo());
        System.out.println("-".repeat(40));
        System.out.println(c1.getInfo());
        System.out.println(c2.getInfo());
    }
}
