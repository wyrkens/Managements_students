package service;

import entity.Accountant;
import interfaces.AccountantDbo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class AccountantDboImpl implements AccountantDbo {

    private final static AccountantDbo instance = new AccountantDboImpl();
    private final String databaseName = "management";
    private final String tableName = "accountantDbo";
    private final String databaseUser = "root";
    private final String databasePassword = "Qwerty33!";
    private Connection connection;

    private AccountantDboImpl() {
        initialization();
    }

    public static AccountantDbo getInstance() {
        return AccountantDboImpl.instance;
    }

    private void initialization() {
        try {
            connection = DriverManager.getConnection(databaseName, databaseUser, databasePassword);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void addAccountant(Accountant accountant) {
        PreparedStatement preparedStatement;
        String insertQuery = "INSERT INTO " + tableName + " (name, lastName, login, password, eMail) " +
                "VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, accountant.getName());
            preparedStatement.setString(2, accountant.getLastName());
            preparedStatement.setString(3, accountant.getLogin());
            preparedStatement.setString(4, accountant.getPassword());
            preparedStatement.setString(5, accountant.getEMail());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void removeAccountantById(int accountantId) {
        PreparedStatement preparedStatement = null;
        String deleteQuery = "DELETE FROM " + tableName + " WHERE id=?";
        try {
            connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, accountantId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void removeAccountantByLogin(String accountantLogin) {
        PreparedStatement preparedStatement = null;
        String deleteQuery = "DELETE FROM " + tableName + " WHERE id=?";
        try {
            connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, accountantLogin);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public List<Accountant> getAllAccountants() {
        List<Accountant> accountantList = new LinkedList<>();
        Statement statement;
        String selectQuery = "SELECT * FROM " + databaseName;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String eMail = resultSet.getString("eMail");
                Accountant accountant = new Accountant(id, name, lastName, login, password, eMail);
                accountantList.add(accountant);
            }
            statement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return accountantList;
    }

    @Override
    public void modifyAccountant(Accountant accountant) {
        PreparedStatement preparedStatement;
        String updateQuery = "UPDATE " + tableName + " SET lastName=?, login=?, password=?, eMail=?";
        try {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, accountant.getLastName());
            preparedStatement.setString(2, accountant.getLogin());
            preparedStatement.setString(3, accountant.getPassword());
            preparedStatement.setString(4, accountant.getEMail());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
