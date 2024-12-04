<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		태그 라이브러리 : jstl/EL(Java Standard Tag Library/ Expresion Language)
		>> jstl 왜 사용하는가?
		: 스크립트릿을 쓸 때 하나씩 일일이 끊어주는 불편함
		
	 -->
	 
	 <!-- 반복문 사용하는 방법  -->
	 <c:forEach begin="1" end="5" step="2">
	 	<h3>아직 4시가 되지 않았다니,,</h3>
	 </c:forEach>
	 
	 <!-- 변수 선언 -->
	 <c:set var="num" value="13" />

	 <!-- EL 표기식  -->
	 <h1>${num}</h1> 	 
	 
	 
	 <!-- 조건문 사용하는 방법  -->
	 <c:if test="${num % 2 == 1}">
    	<h1>홀수입니다.</h1>
	 </c:if>

	 
</body>
</html>