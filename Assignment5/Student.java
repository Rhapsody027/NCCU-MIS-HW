class Student extends Person {
    private String major, tutorName;
    private int enrolledYear;
    private double grade;

    public Student(int id, String name, String major, int enrolledYear, String tutorName, double grade) {
        super(id, name);
        this.major = major;
        this.tutorName = tutorName;
        this.enrolledYear = enrolledYear;
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public String getTutorName() {
        return tutorName;
    }

    public int getEnrolledYear() {
        return enrolledYear;
    }

    public double getGrade() {
        return grade;
    }

    public String getInfo() {
        String info;
        info = String.format("Student[ID=%d, name=%s, major=%s, enrolledYear=%d, grade=%.2f]", this.getId(),
                this.getName(), major, enrolledYear, grade);

        return info;
    }
}