<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="controller.jsp" method="post">
	<input type="hidden" name="action" value="insert">
	<table border="1">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="content"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="uname"></td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="글작성하기"></td>
		</tr>
	</table>

</form>
<hr>
<a href="controller.jsp?action=main">메인페이지로 돌아가기</a>
</body>
</html>