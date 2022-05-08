<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
   <meta charset="utf-8">
   <title>Student_Page</title>
   <link rel="stylesheet" href="noticePage.css">
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
            <li><a href="/MentoringSystem/StudentHomePage">Home</a></li>
            <li><a href="/MentoringSystem/ViewStudentProfilePage?regid=${regid}">My Profile</a></li>
            <li><a href="/MentoringSystem/NoticePage?regid=${regid}" class="active">NOTICES</a></li>
            <li><a href="/MentoringSystem/Logout">LOGOUT</a></li>
         </ul>
      </nav>
      <!-- <br><br><br><br><br> -->

      <div class="content">

         <% ArrayList<String> contentlist = (ArrayList<String>) request.getAttribute("notices");
               ArrayList<String> timestamplist = (ArrayList<String>) request.getAttribute("timestamps");

                     for(int i=0; i<contentlist.size(); i++){ String noticeContent=contentlist.get(i).toString(); String
                        mytimestamp; if(timestamplist.get(i)==null){ mytimestamp="27/05/2021 17:00" ;}
                        else{mytimestamp=timestamplist.get(i).toString();} %>




                        <div class="noticeDiv">
                           <!-- hello -->
                           <%= "[ " + request.getAttribute("myMentorName") + " ] : " + noticeContent%>
                              <br><br>
                              <div class="noticeDate">
                                 [ <%= mytimestamp %> ]

                              </div>

                        </div>
                        <br>
                        <% } %>
      </div>
      <br>
</body>

</html>