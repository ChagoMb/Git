package filter;

import dao.UserDaoFactory;
import model.User;
import myinterface.UserDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(urlPatterns = {"/admin/*", "/security"})
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig config) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        try {
            HttpSession session = req.getSession();

            req.setCharacterEncoding("UTF-8");
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            UserDAO dao = UserDaoFactory.getInstance().getFactoryByProperties();
            User user = dao.findUserByAuth(login, password);
            String role = user.getRole();
            if (role == null) role = "unknown";

            String sesRole = (String) session.getAttribute("role");
            if (sesRole == null) {
                session.setAttribute("role", role);
                session.setAttribute("user", user);
            } else if (role.equalsIgnoreCase("admin")) {
                session.setAttribute("role", role);
            } else if (role.equalsIgnoreCase("user")) {
                session.setAttribute("role", role);
                session.setAttribute("user", user);
            }

            String currentRole = (String) session.getAttribute("role");

            if (req.getServletPath().contains("addUser") && currentRole.equalsIgnoreCase("admin")) {
                req.getRequestDispatcher("/admin/addUser.jsp").forward(req, resp);
            } else if (req.getServletPath().contains("updateUser") && currentRole.equalsIgnoreCase("admin")) {
                req.getRequestDispatcher("/admin/updateUser.jsp").forward(req, resp);
            } else if (req.getServletPath().contains("deleteUser") && currentRole.equalsIgnoreCase("admin")) {
                req.getRequestDispatcher("/admin/deleteUser.jsp").forward(req, resp);
            } else if (currentRole.equalsIgnoreCase("admin")) {
                req.getRequestDispatcher("/admin").forward(req, resp);
            } else if (currentRole.equalsIgnoreCase("user")) {
                req.getRequestDispatcher("/user").forward(req, resp);
            } else {
                req.getRequestDispatcher("/").forward(req, resp);
            }

        } catch (IOException | SQLException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }
}
