package service;

import entity.enums.Classes;
import entity.enums.Sex;
import entity.Student;
import interfaces.StudentDbo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StudentDboImpl implements StudentDbo {

    private final static StudentDbo instance = new StudentDboImpl();
    private final String databaseName = "management";
    private final String tableName = "students";
    private final String databaseUser = "root";
    private final String databasePassword = "Qwerty33!";
    private Connection connection;

    private StudentDboImpl() {
        initialization();
    }

    public static StudentDbo getInstance() {
        return StudentDboImpl.instance;
    }

    private void initialization() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, databaseUser, databasePassword);
            createTable();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    private void createTable() {
        Statement statement;
        String createTable = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "id INT NOT NULL AUTO_INCREMENT UNIQUE," +
                "name VARCHAR(255) NOT NULL," +
                "lastName VARCHAR(255) NOT NULL, " +
                "pesel VARCHAR(255) NOT NULL, " +
                "sex VARCHAR(255) NOT NULL, " +
                "classes VARCHAR(255) NOT NULL, " +
                "address VARCHAR(255)," +
                "phoneNumber VARCHAR(255), " +
                "eMail VARCHAR(255), " +
                "cost INT NOT NULL, " +
                "payment INT, " +
                "debt INT," +
                "PRIMARY KEY (id)" +
                ");";
        try {
            statement = connection.createStatement();
            statement.execute(createTable);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public void addStudent(Student student) {
        PreparedStatement preparedStatement;
        String insertQuery = "INSERT INTO " + tableName + " (name, lastName, pesel, sex, classes, address," +
                " phoneNumber, eMail, cost, payment, debt)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getPesel());
            preparedStatement.setString(4, student.getSex().name());
            preparedStatement.setString(5, student.getClasses().name());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setString(7, student.getPhoneNumber());
            preparedStatement.setString(8, student.getEMail());
            preparedStatement.setInt(9, student.getCost());
            preparedStatement.setInt(10, student.getPayment());
            preparedStatement.setInt(11, student.getDebt());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void removeStudentById(int studentId) {
        PreparedStatement preparedStatement;
        String deleteQuery = "DELETE FROM " + tableName + " WHERE id=?;";
        try {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, studentId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void removeStudentByPesel(String studentPesel) {
        PreparedStatement preparedStatement;
        String deleteQuery = "DELETE FROM " + databaseName + " WHERE pesel=?";
        try {
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, studentPesel);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = new LinkedList<>();
        Statement statement;
        String selectQuery = "SELECT * FROM " + tableName;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String pesel = resultSet.getString("pesel");
                Sex sex = Sex.valueOf(resultSet.getString("sex"));
                Classes classes = Classes.valueOf(resultSet.getString("classes"));
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String eMail = resultSet.getString("eMail");
                int cost = resultSet.getInt("cost");
                int payment = resultSet.getInt("payment");
                int debt = resultSet.getInt("debt");
                Student student = new Student(id, name, lastName, pesel, sex, classes,
                        address, phoneNumber, eMail, cost, payment, debt);
                studentList.add(student);
            }
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void modifyStudent(Student student) {
        PreparedStatement preparedStatement;
        String updateQuery = "UPDATE " + tableName + "SET lastName =?, classes =?, address =?, phoneNumber =?, eMail =?" +
                "WHERE id=?";
        try {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getClasses().name());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEMail());
            preparedStatement.setInt(6, student.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
