package dao;

import myinterface.UserDAO;
import myinterface.UserDaoFactory;
import service.UserServiceHibernate;

public class UserDaoFactoryHibernate implements UserDaoFactory {

    @Override
    public UserDAO createService() {
        return UserServiceHibernate.getInstanceHibernate();
    }
}
