package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT AUTO_INCREMENT, name VARCHAR(256), email VARCHAR(256), acc BIGINT, " +
                "PRIMARY KEY (id), UNIQUE (email))");
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void addUser(User user) throws SQLException {
        createTable();
        PreparedStatement pstmt = connection.prepareStatement("INSERT INTO users " +
                "(name, email, acc) VALUES (?, ?, ?)");
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getMail());
        pstmt.setLong(3, user.getAcc());
        pstmt.executeUpdate();
        pstmt.close();
    }

    public List<User> getAllUsers() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM users");
        ResultSet result = pstmt.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (result.next()) {
            long id = result.getLong(1);
            String name = result.getString(2);
            String email = result.getString(3);
            long acc = result.getLong(4);
            users.add(new User(id, name, email, acc));
        }
        pstmt.close();
        return users;
    }

    public void deleteUser(String name, String email, long acc) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM users " +
                "WHERE name=? AND email=? AND acc=?");
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setLong(3, acc);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void editUser(User user, String name, String email, long acc) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("UPDATE users SET name=?, email=?, acc=? " +
                "WHERE name=? AND email=? AND acc=?");
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setLong(3, acc);
        pstmt.setString(4, user.getName());
        pstmt.setString(5, user.getMail());
        pstmt.setLong(6, user.getAcc());
        pstmt.executeUpdate();
        pstmt.close();
    }
}
