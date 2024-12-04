<%@ page errorPage="Ex04_ErrorPage.jsp"%>
<%@ page import="java.util.ArrayList"%>
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
		1) Page 지시자 : JSP 전체적인 환경설정을 할 때 사용하는 지시자
		2) taglib 지시자 : 태그 라이브러리를 가져올 때 사용하는 지시자
		3) include 지시자 : JSP 내에 또 다른 jsp, html파일을 포함시킬 때 사용하는 지시자
	
	-->
	
	<%
		// page 지시자 - import 구문을 작성할 수 있다.
		// String 형태의 데이터를 보관할 수 있는 가변적인 배열 list 생성
		ArrayList<String> list = new ArrayList<String>();
		
	
	%>

<%= 2/0 %>


</body>
</html>