import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import org.bson.*;

public class addNoticePageServ extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        MongoConnect c = new MongoConnect();
        Document doc;
        ArrayList<String> notices;
        String myMentorName;
        // String regid = (String)req.getSession().getAttribute("regid");
        String regid = req.getParameter("regid").toString().trim();
        if (regid == null) {
            req.setAttribute("error", "Session expired please login again");
            req.getRequestDispatcher("index.jsp").forward(req, response);
        }
        
            doc = MongoConnect.getMentor(regid);
            //notices = MongoConnect.getMentorNotices(regid);
            //myMentorName = MongoConnect.getMentorUserName(regid);
            //req.setAttribute("notices", notices);
            //req.setAttribute("myMentorName", myMentorName);
            req.setAttribute("regid", regid);
            req.getRequestDispatcher("/addNoticePage.jsp").forward(req, response);
        
     }

}
