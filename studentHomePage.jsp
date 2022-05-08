<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
   <meta charset="utf-8">
   <title>Student_Page</title>
   <link rel="stylesheet" href="studentHomePage.css">
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
         <li><a href="/MentoringSystem/StudentHomePage" class="active">Home</a></li>
         <li><a href="/MentoringSystem/ViewStudentProfilePage?regid=${regid}">My Profile</a></li>
         <li><a href="/MentoringSystem/NoticePage?regid=${regid}">NOTICES</a></li>
         <li><a href="/MentoringSystem/Logout">LOGOUT</a></li>
      </ul>
   </nav>
   <div class="content">
      <h1>Welcome <%= request.getAttribute("username")%>
      </h1>
   </div>
</body>
<!-- <script>
   const AppList = ${ notices };
   let currstartind = 0;
   console.log(AppList);
</script> -->

</html>