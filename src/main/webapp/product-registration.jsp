<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container">
    <div class="mt-5 ms-5 me-5">
        <div class="card mb-3">
            <div class="card-header">
                PRODUCT REGISTRATION
            </div>
            <div class="card-body">
                <form action="product" method="post">
                    <div class="form-group">
                        <label for="id-name">Name</label>
                        <input type="text" name="name" id="id-name" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="id-price">Price</label>
                        <input type="text" name="price" id="id-price" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="id-quantity">Quantity</label>
                        <input type="text" name="quantity" id="id-quantity" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="id-manufacture-date">Manufacture Date</label>
                        <input type="date" name="manufactureDate" id="id-manufacture-date" class="form-control">
                    </div>
                    <input type="submit" value="Save" class="btn btn-primary mt-3">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
