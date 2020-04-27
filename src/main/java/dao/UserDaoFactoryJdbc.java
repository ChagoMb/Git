package dao;

import myinterface.UserDAO;
import myinterface.UserDaoFactory;
import service.UserServiceJdbc;

public class UserDaoFactoryJdbc implements UserDaoFactory {

    @Override
    public UserDAO createService() {
        return UserServiceJdbc.getInstanceJdbc();
    }
}
