<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "Study.Product" %>
<%@ page import = "Study.ProductRepository" %>
<jsp:useBean id="productDAO" class ="Study.ProductRepository" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">상품 목록</h1>
        </div>
    </div>
    <%
        ProductRepository dao = ProductRepository.getInstance();
        ArrayList<Product> listOfProducts = dao.getAllProducts();
    %>
    <div class="container">
        <div class="row" align="center">
        <%
            for(int i = 0; i < listOfProducts.size(); i++){
                Product product = listOfProducts.get(i);
        %>
        <div class="col-md-4">
            <img src="./images/<%= product.getFilename() %>" 
            style="width: 100%">
            <h3><%= product.getPname() %></h3>
            <p><%= product.getDescription() %></p>
            <p><%= product.getUnitPrice() %>원</p>
            <p><a href="./product.jsp?id=<%= product.getProductId() %>"
            class="btn btn-secondary" role="button">상세 정보 &raquo;</a></p>
        </div>
        <% 
            } 
        %>
        </div>
        <hr>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>