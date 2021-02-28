package service;

import entity.Sex;
import entity.Student;
import interfaces.StudentDbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StudentDboImpl implements StudentDbo {

    private final static StudentDbo studentDbo = new StudentDboImpl();
    private final String databaseName = "management";
    private final String tableName = "students";
    private final String user = "root";
    private final String password = "Qwerty33!";
    private Connection connection;

    private StudentDboImpl() {
        initialization();
    }

    public static StudentDbo getStudentDbo() {
        return StudentDboImpl.studentDbo;
    }

    private void initialization() {
        try {
            connection = DriverManager.getConnection(databaseName, user, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    @Override
    public void addStudent(Student student) {
        PreparedStatement statement;
        String insertQuery = "insert into " + tableName + " (name, lastName, PESEL, sex, classes, address," +
                " phoneNumber, eMail, cost, payment, debt)" + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, student.getName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getPESEL());
            statement.setString(4, student.getSex().name());
            statement.setString(5, student.getClasses().name());
            statement.setString(6, student.getAddress());
            statement.setString(7, student.getPhoneNumber());
            statement.setString(8, student.getEMail());
            statement.setInt(9, student.getCost());
            statement.setInt(10, student.getPayment());
            statement.setInt(11, student.getDebt());
            statement.execute();
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void removeStudentById(int studentId) {

    }

    @Override
    public void removeStudentByPesel(String studentPesel) {

    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public void modifyStudent(Student student) {

    }
}
