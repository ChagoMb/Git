package servlet;

import myinterface.UserDaoFactory;
import service.Service;
import service.UserServiceHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long id = Long.parseLong(req.getParameter("id"));

            UserDaoFactory daoFactory = Service.getInstance().getFactoryByProperties();
            daoFactory.createService().deleteUser(id);
            resp.sendRedirect("/users");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
