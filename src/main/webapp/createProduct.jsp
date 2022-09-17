
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1 style="text-align: center">
    Create new Product
</h1>
<div style="width: 70%; margin: 0 auto">
    <form onsubmit="saveProduct(event)">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input  type="text" class="form-control" name="name" id="name" placeholder="Some Product">
    </div>
    <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea class="form-control" id="description" name="description" rows="3"></textarea>
    </div>
    <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input  type="number" class="form-control" id="price" name="price" placeholder="Price">
    </div>
    <div class="mb-3">
        <label for="image" class="form-label">Preview Image</label>
        <input  type="file" class="form-control" id="image" name="image" placeholder="Image">
    </div>

        <div id="alert" hidden="hidden" class="alert alert-danger" role="alert">
            Something went wrong. Please try again
        </div>

    <input type="submit" class="btn btn-primary">
    </form>
</div>
<script src="js/product.js"></script>
</body>
</html>
