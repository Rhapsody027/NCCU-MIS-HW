import java.util.ArrayList;

class Student {
    private int studentID, currentCredits, maxCredits;
    private String studentName;
    private ArrayList<Course> enrolledCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.studentName = name;
        this.currentCredits = 0;
        this.maxCredits = 25;
        this.enrolledCourses = new ArrayList<>();
    }

    public Student(int studentID, String name, int maxCredits) {
        this.studentID = studentID;
        this.studentName = name;
        this.currentCredits = 0;
        this.maxCredits = maxCredits;
        this.enrolledCourses = new ArrayList<>();
    }

    public Course getCourse(int id) {
        for (Course course : enrolledCourses) {
            if (course.getCourseID() == id) {
                return course;
            }
        }
        return null;
    }

    public void enroll(Course course) {
        if (!course.isFull()) {
            if (currentCredits + course.getCredits() > maxCredits) {
                System.out.printf("Student %d cannot enroll in this course%n", studentID);
            } else {
                enrolledCourses.add(course);
                course.enroll();
                currentCredits += course.getCredits();
            }
        } else {
            System.out.printf("Course %d is full%n", course.getCourseID());
        }
    }

    public void drop(int courseID) {
        if (getCourse(courseID) != null) {
            Course course = getCourse(courseID);
            enrolledCourses.remove(course);
            course.drop();
            currentCredits -= course.getCredits();
        } else {
            System.out.printf("Course %d not found in student %d%n", courseID, studentID);
        }
    }

    public void drop(Course course) {
        this.drop(course.getCourseID());
    }

    public String getInfo() {
        String info, coursesList = "";

        for (Course course : enrolledCourses) {
            coursesList += String.format("%d %s %d%n",
                    course.getCourseID(), course.getCourseName(), course.getCredits());
        }

        info = "Student ID: " + studentID + "\n"
                + "Name: " + studentName + "\n"
                + "Credits: " + currentCredits + "/" + maxCredits + "\n"
                + "Course list:" + "\n"
                + coursesList;

        return info;
    }
}