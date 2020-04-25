package dao;

import model.User;
import myinterface.UserDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private Session session;

    public UserHibernateDAO(Session session) {
        this.session = session;
    }

    public List<User> getAllUsers() {
        Transaction transaction = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").list();
        transaction.commit();
        session.close();
        return users;
    }

    public void addUser(User user) throws SQLException {
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(long id) throws SQLException {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("DELETE User WHERE id = :id");
        q.setParameter("id", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void updateUser(long id, String name, String email, long acc) throws SQLException {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("UPDATE User SET name = :upName, email = :upMail, acc = :upAcc " +
                "WHERE id = :upId");
        q.setParameter("upName", name);
        q.setParameter("upMail", email);
        q.setParameter("upAcc", acc);
        q.setParameter("upId", id);
        q.executeUpdate();
        transaction.commit();
        session.close();
    }
}
