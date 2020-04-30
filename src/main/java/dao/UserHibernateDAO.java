package dao;

import model.User;
import myinterface.UserDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return users;
    }

    public void addUser(User user) {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(long id) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("DELETE User WHERE id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void updateUser(long id, String name, String email, String password, long acc, String role) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("UPDATE User SET name = :upName, email = :upMail, password = :upPass, " +
                "acc = :upAcc, role = :upRole WHERE id = :upId");
        q.setParameter("upName", name);
        q.setParameter("upMail", email);
        q.setParameter("upPass", password);
        q.setParameter("upAcc", acc);
        q.setParameter("upRole", role);
        q.setParameter("upId", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public User findUserByAuth(String email, String password) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("FROM User WHERE email = :email AND password = :password");
        q.setParameter("email", email);
        q.setParameter("password", password);
        List<User> users = q.list();
        if (users.isEmpty()) {
            return new User();
        }
        User user = users.get(0);
        transaction.commit();
        session.close();
        return user;
    }
}
