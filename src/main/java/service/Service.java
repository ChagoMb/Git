package service;

import dao.UserDaoFactoryHibernate;
import dao.UserDaoFactoryJdbc;
import myinterface.UserDaoFactory;

import java.io.FileReader;
import java.util.Properties;

public class Service {

    private static Service instance;

    private Service() {}

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public UserDaoFactory getFactoryByProperties() {
        Properties property = new Properties();
        FileReader reader;
        try {
            reader = new FileReader("C:\\Users\\Владимир\\IdeaProjects\\preproject1\\src\\main\\resources\\dao.properties");
            property.load(reader);

            String type = property.getProperty("daotype");

            if (type.equalsIgnoreCase("hibernate")) {
                return new UserDaoFactoryHibernate();
            } else if (type.equalsIgnoreCase("jdbc")) {
                return new UserDaoFactoryJdbc();
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
