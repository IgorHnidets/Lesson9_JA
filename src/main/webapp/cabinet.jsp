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
<div>
    <div>
        <b>Name: </b> <span><%= user.getFirstName() + " " + user.getLastName()  %></span>
        <b>Email: </b> <span><%= user.getEmail() %></span>

    </div>
</div>
</body>
</html>
