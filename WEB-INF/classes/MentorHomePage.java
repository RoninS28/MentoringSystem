import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MentorHomePage extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        MongoConnect c = new MongoConnect();
        String username;
        String regid = (String) req.getSession().getAttribute("regid");
        if (regid == null) {
            req.setAttribute("error", "Session expired please login again");
            req.getRequestDispatcher("index.jsp").forward(req, response);
        }
        req.setAttribute("regid", regid);
        username = MongoConnect.getMentorUserName(regid);
        req.setAttribute("username", username);
        // String data = MongoConnect.getAdminPendingLeaves(regid);
        // req.setAttribute("PendingLeaves", data);
        req.getRequestDispatcher("mentorHomePage.jsp").forward(req, response);
    }
}