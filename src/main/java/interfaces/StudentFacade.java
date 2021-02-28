package interfaces;

import entity.Student;

import java.util.List;

public interface StudentFacade {

    String createStudent(Student student);

    String removeStudent(String studentPesel);

    List<Student> getAllStudents();
}
