package service;

import dao.UserDAO;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private static Connection getMySQLConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").
                    append("localhost:3306/").
                    append("db_preproject1?").
                    append("user=root1&password=root").
                    append("&serverTimezone=UTC");

            return DriverManager.getConnection(url.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private UserDAO getUserDAO() {
        return new UserDAO(getMySQLConnection());
    }

    public void createTable() {
        UserDAO dao = getUserDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        UserDAO dao = getUserDAO();
        try {
            dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        UserDAO dao = getUserDAO();
        try {
            return dao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(String name, String email, long acc) {
        UserDAO dao = getUserDAO();
        try {
            dao.deleteUser(name, email, acc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user, String name, String email, long acc) {
        UserDAO dao = getUserDAO();
        try {
            dao.editUser(user, name, email, acc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
