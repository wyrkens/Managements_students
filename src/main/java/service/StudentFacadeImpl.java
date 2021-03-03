package service;

import entity.Student;
import exception.StudentExistException;
import exception.StudentLastNameIsNullException;
import exception.StudentNameIsNullException;
import exception.StudentPeselIsNullException;
import interfaces.StudentFacade;
import interfaces.StudentService;

import java.util.List;

public class StudentFacadeImpl implements StudentFacade {

    private static StudentFacade instance = null;
    private StudentService studentService = StudentServiceImpl.getInstance();

    private StudentFacadeImpl() {
    }

    public static StudentFacade getInstance() {
        if (instance == null) {
            instance = new StudentFacadeImpl();
        }
        return instance;
    }

    @Override
    public String createStudent(Student student) {
        try {
            studentService.addStudent(student);
            return "Dodano studenta: " + student;
        } catch (StudentNameIsNullException
                | StudentPeselIsNullException
                | StudentLastNameIsNullException
                | StudentExistException e) {
            return e.getMessage();
        }
    }

    @Override
    public String removeStudentByPesel(String studentPesel) {
        studentService.removeStudentByPesel(studentPesel);
        return "Usunięto studenta.";
    }

    @Override
    public String removeStudentById(String studentId) {
        studentService.removeStudentByPesel(studentId);
        return "Usunięto studenta.";
    }

}
