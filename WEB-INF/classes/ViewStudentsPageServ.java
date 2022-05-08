import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.ArrayList;

import org.bson.*;

public class ViewStudentsPageServ extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        MongoConnect c = new MongoConnect();
        Document doc;
        ArrayList<String> students;
        String regid = req.getParameter("regid").toString().trim();
        if (regid == null) {
            req.setAttribute("error", "Session expired please login again");
            req.getRequestDispatcher("index.jsp").forward(req, response);
        }
        ArrayList<String> mystudentsregids = MongoConnect.getMyStudentsListRegID(regid);
        ArrayList<String> mystudentsnames = MongoConnect.getMyStudentsListNames(regid);
        ArrayList<String> mystudentsdivision = MongoConnect.getMyStudentsListDivision(regid);
        ArrayList<String> mystudentscontact = MongoConnect.getMyStudentsListContact(regid);

        req.setAttribute("mystudentsregids", mystudentsregids);
        req.setAttribute("mystudentsnames", mystudentsnames);
        req.setAttribute("mystudentsdivision", mystudentsdivision);
        req.setAttribute("mystudentscontact", mystudentscontact);
        req.getRequestDispatcher("/mentorViewStudents.jsp").forward(req, response);

    }
}