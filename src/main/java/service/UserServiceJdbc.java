package service;

import dao.UserJdbcDAO;
import model.User;
import myinterface.UserDAO;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserServiceJdbc implements UserDAO {
    private static UserServiceJdbc instance;

    private UserServiceJdbc() {
    }

    public static UserServiceJdbc getInstanceJdbc() {
        if (instance == null) {
            instance = new UserServiceJdbc();
        }
        return instance;
    }

    public void addUser(User user) {
        UserJdbcDAO dao = DBHelper.getConnection();
        try {
            dao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        UserJdbcDAO dao = DBHelper.getConnection();
        try {
            return dao.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteUser(long id) {
        UserJdbcDAO dao = DBHelper.getConnection();
        try {
            dao.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(long id, String name, String email, String password, long acc, String role) {
        UserJdbcDAO dao = DBHelper.getConnection();
        try {
            dao.updateUser(id, name, email, password, acc, role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUserByAuth(String email, String password) {
        UserJdbcDAO dao = DBHelper.getConnection();
        try {
            return dao.findUserByAuth(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}