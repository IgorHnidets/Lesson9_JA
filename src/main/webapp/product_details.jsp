<%@ page import="JDBC.entiti.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<%
    Product product = (Product) request.getAttribute("product");
%>



<div class="small-container single-product">
    <img src="<%= product.getImage()%>" alt="product" class="prododyct_img"
         style="float: left;padding: 1% 4%" width="45%" height="75%" id="ProductImg">
    <div style="padding-top: 8%">
        <h1 style="font-size: 72px;"><%= product.getName()%></h1>
        <h3 style="font-size: 38px; padding-top: 1%; color: #007214"><%=product.getPrice()%>$</h3>
        <a href="#" style="text-decoration: none"><button class="byton">Buy product</button></a>
    </div>
    <div style="padding-top: 12%; padding-left: 5%;padding-right: 4%">
        <h2 style="font-size: 30px;padding-left: 4%"><%=product.getDescription()%></h2>
        <hr>
        <p style="font-size: 20px"></p>
        <hr>
    </div>
</div>

</body>
</html>
