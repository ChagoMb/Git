package service;

import dao.UserHibernateDAO;
import model.User;
import myinterface.UserDAO;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserServiceHibernate implements UserDAO {

    private SessionFactory sessionFactory;

    private static UserServiceHibernate userServiceHibernate;

    private UserServiceHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserServiceHibernate getInstanceHibernate() {
        if (userServiceHibernate == null) {
            userServiceHibernate = new UserServiceHibernate(DBHelper.getSessionFactory());
        }
        return userServiceHibernate;
    }

    public List<User> getAllUsers() {
        return new UserHibernateDAO(sessionFactory.openSession()).getAllUsers();
    }

    public void addUser(User user) {
        try {
            new UserHibernateDAO(sessionFactory.openSession()).addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long id) {
        try {
            new UserHibernateDAO(sessionFactory.openSession()).deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(long id, String name, String email, String password, long acc, String role) {
        try {
            new UserHibernateDAO(sessionFactory.openSession()).updateUser(id, name, email, password, acc, role);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User findUserByAuth(String email, String password) {
        try {
            return new UserHibernateDAO(sessionFactory.openSession()).findUserByAuth(email, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
