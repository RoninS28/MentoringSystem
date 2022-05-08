<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
   <meta charset="utf-8">
   <title>Mentor_Page</title>
   <link rel="stylesheet" href="mentorHomePage.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
   <nav>
      <div class="logo">
         Mentoring System
      </div>
      <input type="checkbox" id="click">
      <label for="click" class="menu-btn">
         <i class="fas fa-bars"></i>
      </label>
      <ul>
         <li><a href="/MentoringSystem/MentorHomePage" class="active">Home</a></li>
         <li><a href="/MentoringSystem/addNoticePage?regid=${regid}">POST NOTICE</a></li>
         <li><a href="/MentoringSystem/NoticePage?regid=${regid}">MY NOTICES</a></li>
         <li><a href="/MentoringSystem/ViewStudentsPage?regid=${regid}">STUDENTS</a></li>
         <li><a href="/MentoringSystem/Logout">LOGOUT</a></li>
      </ul>
   </nav>
   <div class="content">
      <h1>Welcome <%= request.getAttribute("username")%>
      </h1>
      <!-- <img src="pict_logo.png" height="250px"> -->
   </div>
</body>

</html>