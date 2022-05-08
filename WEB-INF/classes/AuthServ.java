
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.mongodb.client.*;
import org.bson.*;
import com.mongodb.client.model.Filters;

public class AuthServ extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // MongoConnect c = new MongoConnect();
        String username = null;
        MongoConnect c = new MongoConnect();
        String regid = req.getParameter("regid").trim();
        String password = req.getParameter("password").trim();
        String ch = req.getParameter("form_radio");
        String role = null;
        if (ch.equals("Mentor")) {
            System.out.print("mentor is selected");
            role = "MENTOR";
        } else if (ch.equals("Student")) {
            System.out.print("student is selected");
            role = "STUDENT";
        }
        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (!MongoConnect.Authenticate(regid, password, role)) {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("index.jsp").forward(req, response);
        } else {
            Cookie ck = new Cookie("user", regid);
            ck.setMaxAge(60 * 60);
            HttpSession ses = req.getSession();

            ses.setAttribute("regid", regid);
            ses.setMaxInactiveInterval(30 * 60);
            response.addCookie(ck);
            if (role.equals("MENTOR")) {
                // username = c.getMentorUserName(regid);
                // req.setAttribute("username", username);
                response.sendRedirect("MentorHomePage");
            } else {
                // username = c.getStudentUserName(regid);
                // req.setAttribute("username", username);
                response.sendRedirect("StudentHomePage");
            }

            System.out.print("Successful");
        }
        out.flush();
    }

}