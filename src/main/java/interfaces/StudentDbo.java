package interfaces;

import entity.Student;

import java.sql.Struct;
import java.util.List;

public interface StudentDbo {

    void addStudent(Student student);

    void removeStudentById(int studentId);

    void removeStudentByPesel(String studentPesel);

    List<Student> getAllStudents();

    void modifyStudentById(Student student);

}
