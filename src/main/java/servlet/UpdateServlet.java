package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        long acc = Long.parseLong(req.getParameter("acc"));
        String upName = req.getParameter("upName");
        String upMail = req.getParameter("upMail");
        long upAcc = Long.parseLong(req.getParameter("upAcc"));

        User user = new User(name, email, acc);
        UserService.getInstance().editUser(user, upName, upMail, upAcc);
        resp.sendRedirect("/users");        
    }
}
