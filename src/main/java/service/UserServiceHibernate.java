package service;

import dao.UserHibernateDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.util.List;

public class UserServiceHibernate {

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
        } catch(Exception e) {
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

    public void updateUser(long id, String name, String email, long acc) {
        try {
            new UserHibernateDAO(sessionFactory.openSession()).updateUser(id, name, email, acc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
