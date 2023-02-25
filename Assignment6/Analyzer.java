import java.util.ArrayList;

interface Analyzer {
    void addE(ArrayList<Employee> employees);

    int count();

    int sum();

    double avg();

    int max();

    void getInfo();
}