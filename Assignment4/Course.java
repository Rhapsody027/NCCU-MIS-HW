class Course {
    private int courseID, credits, capacity, enrolled;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getCourseID() {
        return courseID;
    }

    public Course(int id, String name, int credits, int capacity) {
        this.courseID = id;
        this.credits = credits;
        this.capacity = capacity;
        this.courseName = name;
        this.enrolled = 0;
    }

    public boolean isFull() {
        if (enrolled >= capacity) {
            return true;
        } else {
            return false;
        }
    }

    public void enroll() {
        enrolled++;
    }

    public void drop() {
        enrolled--;
    }

    public String getInfo() {
        String info;

        info = String.format("%d %s %d %s/%s",
                courseID, courseName, credits, enrolled, capacity);

        return info;
    }
}
