<%@ page import="JDBC.dto.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cabinet</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
    UserDTO user = (UserDTO) request.getAttribute("user");
%>
<div style="padding: 50px 100px;">
    <h1>My profile</h1>
    <br>
    <div style=" font-size: 24px">
        <b>Name: </b> <span><%= user.getFirstName() + " " + user.getLastName()  %></span>
        <br>
        <br>
        <b>Email: </b> <span><%= user.getEmail() %></span>

    </div>
</div>
</body>
</html>
