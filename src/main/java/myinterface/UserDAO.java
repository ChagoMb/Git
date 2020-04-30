package myinterface;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers() throws SQLException;
    void addUser(User user) throws SQLException;
    void deleteUser(long id) throws SQLException;
    void updateUser(long id, String name, String email, String password, long acc, String role) throws SQLException;
    User findUserByAuth(String email, String password) throws SQLException;
}
