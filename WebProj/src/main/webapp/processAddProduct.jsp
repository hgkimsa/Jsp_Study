<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.*"%>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<%@ page import = "Study.Product" %>
<%@ page import = "Study.ProductRepository" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		
		String filename = "";
		String realFolder = "C:\\upload";
		int maxSize = 5 * 1024 * 1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, realFolder,
				maxSize, encType, new DefaultFileRenamePolicy());
	
		String productId = request.getParameter("productId");
		String name = request.getParameter("name");
		String unitPrice = request.getParameter("unitPrice");
		String description = request.getParameter("description");
		String manufacturer = request.getParameter("manufacturer");
		String category = request.getParameter("category");
		String unitsInStock = request.getParameter("unitsInStock");
		String condition = request.getParameter("condition");

		Integer price;
		
		if(unitPrice.isEmpty())
			price = 0;
		else
			price = Integer.valueOf(unitPrice);
		
		long stock;
		
		if (unitsInStock.isEmpty())
			stock = 0;
		else
			stock = Long.valueOf(unitsInStock);
		
		Enumeration files = multi.getFileNames();
		String fname = (String) files.nextElement();
		String fileName = multi.getFilesystemName(fname);
		
		ProductRepository dao = ProductRepository.getInstance();
		
		Product newProduct = new Product();
		newProduct.setProductId(productId);
		newProduct.setPname(name);
		newProduct.setUnitPrice(price);
		newProduct.setDescription(description);
		newProduct.setManufacturer(manufacturer);
		newProduct.setCategory(category);
		newProduct.setUnitsInStock(stock);
		newProduct.setCondition(condition);
		newProduct.setFilename(fileName);
		
		dao.addProduct(newProduct);
		response.sendRedirect("products.jsp");
	%>
</body>
</html>