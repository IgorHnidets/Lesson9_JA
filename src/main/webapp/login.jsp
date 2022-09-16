
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="./css/form.css">
</head>

<body>
<jsp:include page="header.jsp"/>
      <div class="login">
     <div class="login-triangle"></div>

    <h2 class="login-header">Log in</h2>

    <form class="login-container" action="login" method="post">
        <p><input type="email" id="email" name="email" placeholder="Email"></p>
        <p><input type="password" id="pass" name="pass" placeholder="Password"></p>
        <%
            Object error = request.getParameter("err");
            if (error != null){
                out.print("<div class=\"error_message\">Inccorrect login or password. Please try again</div>");
            }
        %>
<%--        <div  class="error_message">Inccorrect login or password. Please try again</div>--%>
        <p><input type="submit" value="Log in"></p>
        <p>Dont have account? <a href="registration.jsp">Registration</a> </p>
    </form>
      </div>

</body>
</html>
