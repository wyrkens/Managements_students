package interfaces;

import entity.Student;

import java.util.List;

public interface StudentService {

    void addStudent();

    void removeStudentById(int studentId);

    List<Student> getAllStudent();

    int getStudentCount();

    Student getStudentByName(String studentName);

    Student getStudentByLastName(String studentLastName);

    int getDebt();

}
