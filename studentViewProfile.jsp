<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Student_Page</title>
    <link rel="stylesheet" href="studentViewProfile.css">
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
            <li><a href="/MentoringSystem/StudentHomePage">Home</a></li>
            <li><a href="/MentoringSystem/ViewStudentProfilePage?regid=${regid}" class="active">My Profile</a></li>
            <li><a href="/MentoringSystem/NoticePage?regid=${regid}">NOTICES</a></li>
            <li><a href="/MentoringSystem/Logout">LOGOUT</a></li>
        </ul>
    </nav>
    <div class="content">
        <div style="text-align: center;">
            <h2>MY PROFILE</h2>
        </div>
        <br>

        <table id="studentViewprofileTable">
            <tr>
                <td>Registeration ID </td>
                <td>:</td>
                <td>
                    <%= request.getAttribute("myRegID") %>
                </td>
            </tr>
            <tr>
                <td>Name </td>
                <td>:</td>
                <td>
                    <%= request.getAttribute("myName") %>
                </td>
            </tr>
            <tr>
                <td>Division </td>
                <td>:</td>
                <td>
                    <%= request.getAttribute("myDiv") %>
                </td>
            </tr>
            <tr>
                <td> Contact No </td>
                <td>:</td>
                <td>
                    <%= request.getAttribute("myContact") %>
                </td>
            </tr>
            <tr>
                <td> Mentor Name </td>
                <td>:</td>
                <td>
                    <%= request.getAttribute("myMentorName") %>
                </td>
            </tr>









        </table>


    </div>
</body>
<!-- <script>
   const AppList = ${ notices };
   let currstartind = 0;
   console.log(AppList);
</script> -->

</html>