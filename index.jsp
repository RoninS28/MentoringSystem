<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="index.css">
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
</head>

<body>
    <div class="wrapper">
        <div class="title">
            <u>Login Page</u>
        </div>

        <form id="registration_form" name="forms" method="POST" action="Auth">
            <p>Log in as</p>
            <div class="radio_field">
                <input type="radio" name="form_radio" value="Mentor" id="mentorRole">Mentor
                <input type="radio" name="form_radio" value="Student" id="studentRole">Student
                <span class="error_form" id="radio_error_message"></span>
            </div>

            <div class="field">
                <input type="text" id="form_reg" required name="regid">
                <label>Reg_Id</label>
                <span class="error_form" id="reg_error_message"></span>
            </div>
            <br>

            <div class="field">
                <input type="password" id="form_password" required="" name="password">
                <label>Password</label>
                <span class="error_form" id="password_error_message"></span>
            </div>
            <br>
            <br>

            <!-- <div class="content">
               <div class="pass-link">
                  <a href="#">Forgot password?</a>
               </div>
            </div> -->

            <div class="field">
                <input type="submit" value="Login" id="btnlogin">
            </div>

            <div class="signup-link">
                Not a member? <a href="#">Signup now</a>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        $(function () {
            $("#reg_error_message").hide();
            $("#password_error_message").hide();
            $("#radio_error_message").hide();

            var error_reg = false;
            var error_password = false;
            var error_radio = false;

            $("#form_reg").focusout(function () {
                check_reg();
            });

            $("#form_password").focusout(function () {
                check_password();
            });

            //
            function check_reg() {
                var pattern;
                // var reg = $("#form_reg").val();
                var a = document.forms.form_radio;
                if (a[0].checked) {
                    pattern = /(M)[0-9]{5}$/;
                }
                else if (a[1].checked) {
                    pattern = /(C2K|I2K|E2K)[0-9]{8}$/;
                }
                var reg = document.getElementById("form_reg").value;

                if (pattern.test(reg) && reg !== '') {
                    $("#reg_error_message").hide();
                    $("#form_reg").css("border", "2px solid #4158d0");
                } else {
                    $("#reg_error_message").html("Invalid Reg_Id");
                    $("#reg_error_message").show();
                    $("#form_reg").css("border", "1px solid #F90A0A");
                    error_reg = true;
                }
            }
            //
            function check_password() {
                var password_length = $("#form_password").val().length;
                var pass = document.getElementById("form_password").value;

                if (password_length < 8) {
                    $("#password_error_message").html("Atleast 8 Characters");
                    $("#password_error_message").show();
                    $("#form_password").css("border", "1px solid #F90A0A");
                    error_password = true;
                } else {
                    $("#password_error_message").hide();
                    $("#form_password").css("border", "2px solid #4158d0");
                }
            }
            //
            function validate_radio() {
                var a = document.forms.form_radio;
                for (i = 0; i < a.length; i++) {
                    if (a[i].checked == true) {
                        return;
                    }
                }

                $("#radio_error_message").html("Select one option");
                $("#radio_error_message").show();
                error_radio = true;
            }
            //
            $("#registration_form").submit(function () {
                error_radio = false;
                error_password = false;
                error_reg = false;

                check_reg();
                check_password();
                validate_radio();

                if (error_password == false && error_reg == false && error_radio == false) {
                    // alert("Logged in successful");
                    return true;
                }
                else {

                    alert("Please fill the Form correctly");
                    return false;
                }

            });

        });

        let mssg = "${error}";
        if (mssg != "" && mssg != "null") {
            alert(mssg);
        }

    </script>
    <noscript>
        Sorry, your brower does not support javascript!
    </noscript>
</body>

</html>