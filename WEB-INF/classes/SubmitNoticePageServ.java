
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.mongodb.client.*;
import org.bson.*;
import com.mongodb.client.model.Filters;

public class SubmitNoticePageServ extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // MongoConnect c = new MongoConnect();
        String username = null;
        MongoConnect c = new MongoConnect();
        //String regid = req.getParameter("regid");
        String regid = req.getSession().getAttribute("regid").toString();
        //String password = req.getParameter("password").trim();
        //String ch = req.getParameter("form_radio");
        String content = req.getParameter("addNotice").toString().trim();
        
        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        MongoConnect.addNotice(regid,content);

            Cookie ck = new Cookie("user", regid);
            ck.setMaxAge(60 * 60);
            HttpSession ses = req.getSession();

            //String reg = "\""+ regid +"\"";
            ses.setAttribute("regid", regid);
            ses.setMaxInactiveInterval(30 * 60);
            req.setAttribute("regid", regid);
            response.addCookie(ck);
            
                // username = c.getMentorUserName(regid);
                // req.setAttribute("username", username);
                //req.getRequestDispatcher("/MentorHomePage").forward(req, response);
                response.sendRedirect("MentorHomePage");

        
        out.flush();
    }

}