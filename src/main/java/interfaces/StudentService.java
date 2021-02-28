package interfaces;

import entity.Student;

import java.util.List;

public interface StudentService {

    boolean addStudent(Student student);

    void removeStudentById(int studentId);

    void removeStudentByPesel(String studentPesel);

    List<Student> getAllStudents();

    Student getStudentByPesel(String studentPesel);

    int getStudentCount();

    boolean isStudentWithPeselExist(String studentPesel);

}
