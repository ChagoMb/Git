package servlet;

import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

            if (user == null) {
                resp.getWriter().println("Sorry, user is not auth!");
            } else {
                req.setAttribute("name", user.getName());
                req.setAttribute("email", user.getMail());
                req.setAttribute("acc", user.getAcc());
                req.setAttribute("role", user.getRole());
                req.getRequestDispatcher("user.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
