package interfaces;

import entity.Student;

import java.util.List;

public interface StudentFacade {

    String createStudent(Student student);

    String removeStudentByPesel(String studentPesel);

    String removeStudentById(String studentId);
}
