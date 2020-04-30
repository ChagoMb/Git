package servlet;

import dao.UserDaoFactory;
import myinterface.UserDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            long id = Long.parseLong(req.getParameter("id"));

            UserDAO daoFactory = UserDaoFactory.getInstance().getFactoryByProperties();
            daoFactory.deleteUser(id);
            resp.sendRedirect("/admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
