<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculation Result</title>
</head>
<body>

<%
    // 요청 파라미터에서 값 가져오기
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
    String operator = request.getParameter("op");
    
    // 계산 결과 변수 초기화
    int result = 0;
    boolean validOperation = true;
    
    // 연산 수행
    switch(operator) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                validOperation = false;
            }
            break;
        default:
            validOperation = false;
    }
%>

<% if (validOperation) { %>
    <p><%= num1 %> <%= operator %> <%= num2 %> = <%= result %></p>
<% } else { %>
    <p>0으로 나눌수 없거나 선택된 연산자가 잘못되었습니다.</p>
<% } %>
</body>
</html>
