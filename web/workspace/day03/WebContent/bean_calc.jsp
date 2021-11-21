<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bc" class="day03.bean_cal"/>
<jsp:setProperty property="*" name="bc"/>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getMethod().equals("POST")){
	bc.Bean_cal();
}

%>
	<form method="post">
		<input type="text" name="num1"> <select name="op">
			<option selected>+</option>
			<option>-</option>
		</select> <input type="text" name="num2"> <input type="submit"
			value="계산하기">
	</form>
	<hr>
	<h2>
		계산결과는
		<jsp:getProperty property="res" name="bc"/>입니다<br>
	</h2>
</body>
</html>