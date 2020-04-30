package servlet;

        import dao.UserDaoFactory;
        import myinterface.UserDAO;

        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
            long id = Long.parseLong(req.getParameter("id"));
            String name = req.getParameter("upName");
            String email = req.getParameter("upMail");
            String password = req.getParameter("upPass");
            long acc = Long.parseLong(req.getParameter("upAcc"));
            String role = req.getParameter("upRole");

            UserDAO daoFactory = UserDaoFactory.getInstance().getFactoryByProperties();
            daoFactory.updateUser(id, name, email, password, acc, role);
            resp.sendRedirect("/admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
