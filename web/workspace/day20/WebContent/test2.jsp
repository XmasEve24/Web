<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,javax.sql.*,javax.naming.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>데이터 목록</h2>
<hr>
<c:forEach var="v" items="${datas}">
	<li>
		mid: ${v.mid}<br>
		mpw: ${v.mpw}<br>
		mname: ${v.mname}<br>
	</li>
</c:forEach>
</body>
</html>