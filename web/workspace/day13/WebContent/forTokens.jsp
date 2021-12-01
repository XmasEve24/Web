<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forTokens items="카이사,이즈리얼,루시안,케이틀린,그레이브즈" delims="," var="v">
	${v} <br>
</c:forTokens>


</body>
</html>