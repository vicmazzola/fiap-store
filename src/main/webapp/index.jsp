<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>FiapStore</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <div class="mt-5 ms-5 me-5">

        <div class="card mb-3">
            <div class="card-header">
                PRODUCT LIST
            </div>
            <div class="card-body">
                <h5 class="card-title">Efficient product management</h5>
                <p class="card-text">Keep your product data always updated and accessible.</p>
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th class="text-end">Quantity</th>
                        <th class="text-end">Price</th>
                        <th class="text-center">Manufacture Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Wireless Mouse</td>
                        <td class="text-end">100</td>
                        <td class="text-end">30.99</td>
                        <td class="text-center">15-09-2024</td>
                    </tr>
                    <tr>
                        <td>LED Monitor 23"</td>
                        <td class="text-end">16</td>
                        <td class="text-end">700.00</td>
                        <td class="text-center">21-11-2023</td>
                    </tr>
                    <tr>
                        <td>HP Printer</td>
                        <td class="text-end">6</td>
                        <td class="text-end">768.99</td>
                        <td class="text-center">09-04-2024</td>
                    </tr>
                    </tbody>
                </table>
                <a href="product-registration.jsp" class="btn btn-primary">Add product</a>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
