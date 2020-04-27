package servlet;

import model.User;
import myinterface.UserDaoFactory;
import service.Service;
import service.UserServiceHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/users")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            long acc = Long.parseLong(req.getParameter("acc"));

            User user = new User(name, email, acc);
            UserDaoFactory daoFactory = Service.getInstance().getFactoryByProperties();
            daoFactory.createService().addUser(user);
            resp.sendRedirect("/users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UserDaoFactory daoFactory = Service.getInstance().getFactoryByProperties();
            List<User> users = daoFactory.createService().getAllUsers();

            req.setAttribute("users", users);
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
