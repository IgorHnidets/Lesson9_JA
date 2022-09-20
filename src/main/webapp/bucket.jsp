<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.09.2022
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/bucket.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container bucket-container">
    <div class="bucket-item">
        <div class="image">
            <img width="150px" height="150px" src="https://cdns.iconmonstr.com/wp-content/releases/preview/2019/240/iconmonstr-product-3.png"
                 alt="product">
        </div>

        <div class="content">
            <h3>Name</h3>
            <p>
                Lorem ipsum dolor sit amet.
            </p>
        </div>
        <div class="buttons">
            <button class="btn btn-danger">Remove</button>
        </div>

    </div>
</div>

</body>
</html>
