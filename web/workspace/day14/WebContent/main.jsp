<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.board.BoardVO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

<table border="1">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th>
	</tr>
	<c:forEach var="v" items="${datas}">
		<tr>
			<td><a href="controller.jsp?action=board&idx=${v.idx}">${v.idx}</a></td><td>${v.title}</td><td>${v.uname}</td>
		</tr>
	</c:forEach>
</table>

<a href="form.jsp">글작성하기</a>
</body>
</html>