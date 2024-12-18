<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Study.Product" %>
<%@ page import="Study.ProductRepository" %>
<%@ page import="java.sql.*" %>
<jsp:useBean id="productDAO" class="Study.ProductRepository" scope="session"/>
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
    <div class="container">
        <div class="row" align="center">
        <%
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            
            try {
                String url = "jdbc:mysql://localhost:3306/WebMarketDB";
                String user = "root";
                String password = "1234";
                
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, user, password);
                
                String sql = "select * from product";
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                
                while (rs.next()) {
        %>
            <div class="col-md-4">
                <img src="./images/<%= rs.getString("p_fileName") %>" style="width: 100%">
                <h3><%= rs.getString("p_name") %></h3>
                <p><%= rs.getString("p_description") %></p>
                <p><%= rs.getInt("p_unitPrice") %>원</p>
                <p><a href="./product.jsp?id=<%= rs.getString("p_id") %>"
                class="btn btn-secondary" role="button">상세 정보 &raquo;</a></p>
            </div>
        <% 
                }
            } catch (SQLException ex) {
                out.println("데이터베이스 연결이 실패했습니다.<br>");
                out.println("SQLException: " + ex.getMessage());
            } finally {
                if (rs != null) try { rs.close(); } catch(SQLException ex) {}
                if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
                if (conn != null) try { conn.close(); } catch(SQLException ex) {}
            }
        %>
        </div>
        <hr>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
