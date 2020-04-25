package service;

import dao.UserJdbcDAO;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserServiceJdbc {
    private static UserServiceJdbc instance;

    private UserServiceJdbc() {
    }

    public static UserServiceJdbc getInstanceJdbc() {
        if (instance == null) {
            instance = new UserServiceJdbc();
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

    private UserJdbcDAO getUserDAO() {
        return new UserJdbcDAO(getMySQLConnection());
    }

    public void addUser(User user) {
        UserJdbcDAO dao = getUserDAO();
        try {
            dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        UserJdbcDAO dao = getUserDAO();
        try {
            return dao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(long id) {
        UserJdbcDAO dao = getUserDAO();
        try {
            dao.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Long id, String name, String email, long acc) {
        UserJdbcDAO dao = getUserDAO();
        try {
            dao.updateUser(id, name, email, acc);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}