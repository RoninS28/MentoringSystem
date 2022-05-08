<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Student_Page</title>
    <link rel="stylesheet" href="mentorViewStudents.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />

    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <%@ page import="java.util.ArrayList, java.io.*" %>

        <nav style="margin-bottom: 50px;">
            <div class="logo">
                Mentoring System
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li><a href="/MentoringSystem/MentorHomePage">Home</a></li>
                <li><a href="/MentoringSystem/addNoticePage?regid=${regid}">POST NOTICE</a></li>
                <li><a href="/MentoringSystem/NoticePage?regid=${regid}">MY NOTICES</a></li>
                <li><a href="/MentoringSystem/ViewStudentsPage?regid=${regid}" class="active">STUDENTS</a></li>
                <li><a href="/MentoringSystem/Logout">LOGOUT</a></li>
            </ul>
        </nav>
        <!-- <br><br><br><br><br> -->

        <div class="content" style="text-align: center; align-items: center; max-width: auto; margin: auto;">
            <div style="text-align: center;">
                <h2>STUDENTS UNDER MY MENTORING</h2>
            </div>

            <table id="viewStudentsTable">
                <tr>
                    <th>Registeration ID</th>
                    <th>Name of Student</th>
                    <th>Class</th>
                    <th>Contact No</th>
                </tr>


                <% ArrayList<String> mystudentsdivisionlist = (ArrayList<String>)
                        request.getAttribute("mystudentsdivision");
                        ArrayList<String> mystudentsnameslist = (ArrayList<String>)
                                request.getAttribute("mystudentsnames");
                                ArrayList<String> mystudentsregidslist = (ArrayList<String>)
                                        request.getAttribute("mystudentsregids");
                                        ArrayList<String> mystudentscontactlist = (ArrayList<String>)
                                                request.getAttribute("mystudentscontact");

                                                for(int i=0; i<mystudentsregidslist.size(); i++) { %>


                                                    <!-- <div class="noticeDiv"> -->
                                                    <tr>
                                                        <td>
                                                            <%= mystudentsregidslist.get(i).toString()%>
                                                        </td>
                                                        <td>
                                                            <%= mystudentsnameslist.get(i).toString()%>
                                                        </td>
                                                        <td>
                                                            <%= mystudentsdivisionlist.get(i).toString()%>
                                                        </td>
                                                        <td>
                                                            <%= mystudentscontactlist.get(i).toString()%>
                                                        </td>
                                                    </tr>
                                                    <!-- <%= "[ " + mystudentsdivisionlist.get(i).toString() + " ] : " +
                                                    mystudentsnameslist.get(i).toString() + " " +
                                                    mystudentsregidslist.get(i).toString()%> -->


                                                    <!-- </div> -->
                                                    <br>
                                                    <% } %>
            </table>
        </div>
        <br>
</body>

</html>