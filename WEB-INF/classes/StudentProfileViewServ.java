import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import org.bson.*;

public class StudentProfileViewServ extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        MongoConnect c = new MongoConnect();
        Document doc;
        ArrayList<String> students;
        String regid = req.getParameter("regid").toString().trim();
        if (regid == null) {
            req.setAttribute("error", "Session expired please login again");
            req.getRequestDispatcher("index.jsp").forward(req, response);
        }
        StudentProfileSchema student = new StudentProfileSchema();

        student = MongoConnect.getStudentProfile(regid);

        req.setAttribute("myRegID", student.RegID);
        req.setAttribute("myName", student.Name);
        req.setAttribute("myDiv", student.Div);
        req.setAttribute("myContact", student.Contact);
        req.setAttribute("myMentorName", student.MentorName);

        req.getRequestDispatcher("/studentViewProfile.jsp").forward(req, response);

    }
}