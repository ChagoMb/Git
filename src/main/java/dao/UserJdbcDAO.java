package dao;

import model.User;
import myinterface.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT AUTO_INCREMENT, acc BIGINT, email VARCHAR(256), name VARCHAR(256), " +
                "password VARCHAR(256), role VARCHAR(256), PRIMARY KEY (id), UNIQUE (email), UNIQUE (password))");
        pstmt.execute();
        pstmt.close();
    }

    public void addUser(User user) throws SQLException {
        createTable();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users " +
                "(acc, email, name, password, role) VALUES (?, ?, ?, ?, ?)");
        pstmt.setLong(1, user.getAcc());
        pstmt.setString(2, user.getMail());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPassword());
        pstmt.setString(5, user.getRole());

        pstmt.executeUpdate();
        pstmt.close();
    }

    public List<User> getAllUsers() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users");
        ResultSet result = pstmt.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong(1);
            String name = result.getString(4);
            String email = result.getString(3);
            String password = result.getString(5);
            long acc = result.getLong(2);
            String role = result.getString(6);
            users.add(new User(id, name, email, password, acc, role));
        }
        pstmt.close();
        return users;
    }

    public void deleteUser(long id) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM users " +
                "WHERE id=?");
        pstmt.setLong(1, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void updateUser(long id, String name, String email, String password, long acc, String role) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("UPDATE users SET name=?, email=?, password=?, " +
                "acc=?, role=? WHERE id=?");
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, password);
        pstmt.setLong(4, acc);
        pstmt.setString(5, role);
        pstmt.setLong(6, id);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public User findUserByAuth(String email, String password) throws SQLException {
        createTable();
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users " +
                "WHERE email=? AND password=?");
        pstmt.setString(1, email);
        pstmt.setString(2, password);
        ResultSet result = pstmt.executeQuery();
        User user;
        if (!result.next()) {
            return new User();
        } else {
            long id = result.getLong(1);
            String name = result.getString(4);
            String mail = result.getString(3);
            String pass = result.getString(5);
            long acc = result.getLong(2);
            String role = result.getString(6);
            user = new User(id, name, mail, pass, acc, role);
        }
        pstmt.close();
        return user;
    }
}
