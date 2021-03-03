package interfaces;

import entity.Student;
import exception.StudentExistException;
import exception.StudentLastNameIsNullException;
import exception.StudentNameIsNullException;
import exception.StudentPeselIsNullException;

import java.util.List;

public interface StudentService {

    boolean addStudent(Student student) throws StudentExistException, StudentNameIsNullException, StudentLastNameIsNullException, StudentPeselIsNullException;

    void removeStudentById(int studentId);

    void removeStudentByPesel(String studentPesel);

    List<Student> getAllStudents();

    Student getStudentByPesel(String studentPesel);

    int getStudentCount();

    boolean isStudentWithPeselExist(String studentPesel);

}
