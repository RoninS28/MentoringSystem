<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <title>Post Notice</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="addNoticePage.css">

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
                <li><a href="/MentoringSystem/addNoticePage?regid=${regid}" class="active">POST NOTICE</a></li>
                <li><a href="/MentoringSystem/NoticePage?regid=${regid}">MY NOTICES</a></li>
                <li><a href="/MentoringSystem/ViewStudentsPage?regid=${regid}">STUDENTS</a></li>
                <li><a href="/MentoringSystem/Logout">LOGOUT</a></li>
            </ul>
        </nav>
        <br>
        <!-- <br><br><br><br><br> -->

        <div class="content">
            <div id="addNoticePageDiv">
                <form action="SubmitNoticePage" method="post" onsubmit="validateNewNotice()">
                    <textarea name="addNotice" id="addNotice" cols="70" autofocus="true" rows="10"
                        placeholder="Enter New Notice here">


                    </textarea>
                    <br>

                    <button type="submit" id="postNotice">Post Notice</button>


                </form>
                <div></div>

            </div>













        </div>
        <br>
        <script>
            function validateNewNotice() {
                let regid = "${regid}";
                console.log('reg is is ' + regid);
                console.log(document.getElementById("addNotice").value);
                if (document.getElementById("addNotice").value == "") {
                    return false;
                }
                else if (document.getElementById("addNotice").value == null) {
                    return false;
                }
                return true;

            }
        </script>
</body>

</html>