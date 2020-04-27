package servlet;

import myinterface.UserDaoFactory;
import service.Service;
import service.UserServiceHibernate;
import service.UserServiceJdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            String upName = req.getParameter("upName");
            String upMail = req.getParameter("upMail");
            long upAcc = Long.parseLong(req.getParameter("upAcc"));

            UserDaoFactory daoFactory = Service.getInstance().getFactoryByProperties();
            daoFactory.createService().updateUser(id, upName, upMail, upAcc);
            resp.sendRedirect("/users");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
