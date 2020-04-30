package servlet;

import dao.UserDaoFactory;
import model.User;
import myinterface.UserDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            UserDAO daoFactory = UserDaoFactory.getInstance().getFactoryByProperties();
            List<User> users = daoFactory.getAllUsers();

            req.setAttribute("users", users);
            req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}