import java.util.ArrayList;

class Instructor extends Person {
    private String department;
    private ArrayList<String> lectureList = new ArrayList<>();
    private ArrayList<Student> studentList = new ArrayList<>();

    public Instructor(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<String> getLectureList() {
        return lectureList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void addLecture(String lectureName) {
        lectureList.add(lectureName);
    }

    public boolean addStudent(Student student) {
        if (student.getTutorName() == this.getName()) {
            studentList.add(student);
            return true;
        }

        return false;
    }

    public String getLectureName() {
        String str = "";

        for (String s : lectureList) {
            str += s;
            if (s != lectureList.get(lectureList.size() - 1)) {
                str += ", ";
            }
        }

        return str;
    }

    public String getStudentName() {
        String str = "";

        for (Student s : studentList) {
            str += s.getName();
            if (s.getName() != studentList.get(studentList.size() - 1).getName()) {
                str += ", ";
            }
        }

        return str;
    }

    public double getStudentAverage() {
        double avg = 0;

        for (Student student : studentList) {
            avg += student.getGrade();
        }

        return avg / studentList.size();
    }

    public String getInfo() {
        String info;
        info = String.format("Instructor[ID=%d, name=%s, department=%s, lectureList=%s, studentList=%s]", this.getId(),
                this.getName(), department, getLectureName(), getStudentName());

        return info;
    }
}