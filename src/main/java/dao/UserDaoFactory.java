package dao;

import myinterface.UserDAO;
import service.UserServiceHibernate;
import service.UserServiceJdbc;

import java.io.FileReader;
import java.util.Properties;

public class UserDaoFactory {

    private static UserDaoFactory instance;

    private UserDaoFactory() {
    }

    public static UserDaoFactory getInstance() {
        if (instance == null) {
            instance = new UserDaoFactory();
        }
        return instance;
    }

    public UserDAO getFactoryByProperties() {
        Properties property = new Properties();
        FileReader reader;
        try {
            reader = new FileReader("C:\\Users\\Владимир\\IdeaProjects\\preproject1\\src\\main\\resources\\dao.properties");
            property.load(reader);

            String type = property.getProperty("daotype");

            if (type.equalsIgnoreCase("hibernate")) {
                return UserServiceHibernate.getInstanceHibernate();
            } else if (type.equalsIgnoreCase("jdbc")) {
                return UserServiceJdbc.getInstanceJdbc();
            }
            else {
                throw new RuntimeException("Unknown property key");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
