import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import org.bson.*;

public class NoticePageServ extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        MongoConnect c = new MongoConnect();
        Document doc;
        ArrayList<String> notices;
        ArrayList<String> timestamps;
        String myMentorName;
        // String regid = (String)req.getSession().getAttribute("regid");
        String regid = req.getParameter("regid").toString().trim();
        if (regid == null) {
            req.setAttribute("error", "Session expired please login again");
            req.getRequestDispatcher("index.jsp").forward(req, response);
        }
        if (regid.contains("M")) {// user is a mentor and he should get his own notices
            doc = MongoConnect.getUser(regid);
            notices = MongoConnect.getMentorNotices(regid);
            timestamps = MongoConnect.getMentorNoticeTimestamps(regid);
            myMentorName = MongoConnect.getMentorUserName(regid);
            req.setAttribute("notices", notices);
            req.setAttribute("myMentorName", myMentorName);
            req.setAttribute("timestamps", timestamps);
            req.getRequestDispatcher("/mentorNoticePage.jsp").forward(req, response);
        } else {// user is a student and he should get his mentor's notices
            doc = MongoConnect.getUser(regid);
            notices = MongoConnect.getRequest(regid);
            String mentorid = MongoConnect.getMyMentorID(regid);
            timestamps = MongoConnect.getMentorNoticeTimestamps(mentorid);
            myMentorName = MongoConnect.getMentorName(regid);
            req.setAttribute("notices", notices);
            req.setAttribute("myMentorName", myMentorName);

            req.setAttribute("timestamps", timestamps);
            req.getRequestDispatcher("/studentNoticePage.jsp").forward(req, response);
        }

    }
}