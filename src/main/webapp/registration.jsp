
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="./css/form.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="login">
    <div class="login-triangle"></div>

    <h2 class="login-header">Sign Up</h2>

    <form class="login-container" action="registration" method="post" onsubmit="handleregister(event)">
        <p><input type="text" id="first_name" name="firstname" placeholder="First name"></p>
        <p><input type="text" id="last_name" name="lastname" placeholder="Last name"></p>
        <p><input type="email" id="email" name="email" placeholder="Email"></p>
        <p><input type="password" id="pass" name="password" placeholder="Password"></p>
        <p><input type="password" id="confirmation" name="confirmation" placeholder="Confirm Password"></p>
        <div id="message" class="error_message"></div>
        <p><input type="submit" value="Sign Up"></p>
        <p>Already have account? <a href="login.jsp">Log In</a> </p>
    </form>
</div>



<script src="js/registr.js"></script>
</body>
</html>
