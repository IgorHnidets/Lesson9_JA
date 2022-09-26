<%@ page import="JDBC.dto.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Header</title>
    <%-- Bootstrap--%>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <%-- FONT AWESOME  --%>
    <script src="https://kit.fontawesome.com/25ffb0d0eb.js" crossorigin="anonymous"></script>
</head>
<body>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="index.jsp" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="index.jsp" class="nav-link px-2 text-white">Home</a></li>
                <li><a href="user" class="nav-link px-2 text-white">Cabinet</a></li>
                <li><a href="bucket.jsp" class="nav-link px-2 text-white">Bucket</a></li>
                <li><a id="create" href="createProduct.jsp" class="nav-link px-2 text-white">Create product</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Contacts</a></li>
            </ul>




            <%--                <%--%>
            <%--                    String name = (String) session.getAttribute("userName");--%>
            <%--//                    if (name == null){--%>
            <%--//                        out.print("<button type=\"button\" class=\"btn btn-outline-light me-2\"><a href=\"login.jsp\">Login</a></button>\n" +--%>
            <%--//                                "                <button type=\"button\" class=\"btn btn-warning\"><a href=\"registration.jsp\">Registration</a></button>");--%>
            <%--//                    } else {--%>
            <%--//                        out.print("<button type=\"button\" class=\"btn btn-warning\"><a href=\"Logout\">Logout</a></button>");--%>
            <%--//                    }--%>
            <%--                %>--%>
            <%--                <span style="display: <%= name == null ? "inline" : "none"%>">--%>
            <div class="text-end">
                <%
                    String name = (String) session.getAttribute("userName");
                    String role = (String) session.getAttribute("userRole");
                    if (name == null){
                        out.print("");
                    }else {
                    }
                %>
                <span style="display: <%= name == null ? "inline" : "none"%> ">

                <button type="button" class="btn btn-outline-light me-2">
                    <a href="login.jsp">Login</a>
                </button>

                <button type="button" class="btn btn-warning">
                    <a href="registration.jsp">Sign Up</a>
                </button>
                </span>

                <button style="display: <%= name != null ? "inline" : "none"%> " type="button" class="btn btn-warning">
                    <a href="logOut">Logout</a>
                </button>

            </div>
        </div>
    </div>
</header>
<script>
    const role = '<%=role%>';
    console.log(role);
    if(role !== 'ADMIN'){
        document.getElementById("create").setAttribute("hidden","hidden");
    }
    const item = localStorage.getItem("userId");
    const userIdFromSession = <%=session.getAttribute("userId")%>
    if (userIdFromSession !== item){
        localStorage.setItem('userId', userIdFromSession);
    }

</script>
</body>
</html>
