class DoubleMajor extends Student {
    private String major2;

    public DoubleMajor(int id, String name, String major, int enrolledYear, String tutorName, double grade,
            String major2Name) {
        super(id, name, major, enrolledYear, tutorName, grade);
        this.major2 = major2Name;
    }

    public String getMajor2() {
        return major2;
    }

    public String getInfo() {
        String info;
        info = String.format("DoubleMajor[ID=%d, name=%s, major=%s, major2=%s, enrolledYear=%d, grade=%.2f]",
                this.getId(),
                this.getName(), this.getMajor(), major2, this.getEnrolledYear(), this.getGrade());

        return info;
    }
}