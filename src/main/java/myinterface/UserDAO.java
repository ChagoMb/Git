package myinterface;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> getAllUsers() throws SQLException;
    void addUser(User user) throws SQLException;
    void deleteUser(long id) throws SQLException;
    void updateUser(long id, String name, String email, long acc) throws SQLException;
}
