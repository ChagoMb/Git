package servlet;

import dao.UserDaoFactory;
import model.User;
import myinterface.UserDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")
public class CreateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            long acc = Long.parseLong(req.getParameter("acc"));
            String role = req.getParameter("role");

            User user = new User(name, email, password, acc, role);
            UserDAO daoFactory = UserDaoFactory.getInstance().getFactoryByProperties();
            daoFactory.addUser(user);
            resp.sendRedirect("/admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
