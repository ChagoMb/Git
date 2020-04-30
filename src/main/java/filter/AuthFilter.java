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

@WebFilter(urlPatterns = "/security")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig config) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        try {
            req.setCharacterEncoding("UTF-8");
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            UserDAO daoFactory = UserDaoFactory.getInstance().getFactoryByProperties();
            User user = daoFactory.findUserByAuth(login, password);
            String role = user.getRole();
            if (role == null) {
                role = "empty";
            }
            if ((login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
                    || role.equalsIgnoreCase("admin")) {

                resp.sendRedirect("/admin");
            } else if (role.equalsIgnoreCase("user")) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("/user");
            }
            else {
                resp.sendRedirect("startPage.jsp");
            }
        }catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
    }
}
