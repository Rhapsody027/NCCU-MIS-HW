public class Assignment5 {
    public static void main(String[] args) {
        Person person = new Person(109306501, "Alex");
        Instructor tutor1 = new Instructor(111306100, "Jennifer", "MIS");
        Instructor tutor2 = new Instructor(111306101, "Bob", "MIS");

        tutor1.addLecture("OOPI");
        tutor1.addLecture("OOPII");
        tutor2.addLecture("OOPI");

        Student student1 = new Student(1093060502, "Amy", "MIS", 107,
                tutor1.getName(), 95);
        Student student2 = new Student(1093060503, "Joy", "Acc", 108,
                tutor1.getName(), 88);
        DoubleMajor student3 = new DoubleMajor(1093060504, "David", "MIS", 106,
                tutor2.getName(), 89, "CS");

        System.out.println(tutor1.addStudent(student1));
        System.out.println(tutor1.addStudent(student2));
        System.out.println(tutor1.addStudent(student3));
        System.out.println(person.getInfo());
        System.out.println(tutor1.getInfo());
        System.out.println(student1.getInfo());
        System.out.println(student2.getInfo());
        System.out.println(student3.getInfo());
        System.out.println("-".repeat(10));
        System.out.println(tutor1.getStudentName());
        System.out.println(tutor1.getStudentAverage());
    }
}
