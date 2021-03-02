package service;

import entity.Student;
import interfaces.StudentDbo;
import interfaces.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static StudentServiceImpl instance = null;
    private StudentDbo studentDbo = StudentDboImpl.getInstance();

    private StudentServiceImpl() {
    }

    public static StudentServiceImpl getInstance() {
        if (instance == null) {
            return new StudentServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean addStudent(Student student) {
        if (isStudentWithPeselExist(student.getPesel())) {
            throw new StudentExistException();
        }
        if (studentValidator.isValidate(student)) {
            studentDbo.addStudent(student);
            return true;
        }
        return false;
    }

    @Override
    public void removeStudentById(int studentId) {
        studentDbo.removeStudentById(studentId);
    }

    @Override
    public void removeStudentByPesel(String studentPesel) {
        studentDbo.removeStudentByPesel(studentPesel);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDbo.getAllStudents();
    }

    @Override
    public Student getStudentByPesel(String studentPesel) {
        List<Student> studentList = getAllStudents();
        for (Student students : studentList) {
            if (students.getPesel().equals(studentPesel)) {
                return students;
            }
        }
        return null;
    }

    @Override
    public int getStudentCount() {
        return getAllStudents().size();
    }

    @Override
    public boolean isStudentWithPeselExist(String studentPesel) {
        Student student = null;
        student = getStudentByPesel(studentPesel);
        return student != null;
    }
}
