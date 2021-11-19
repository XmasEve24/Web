<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("UTF-8");
	if (session.getAttribute("uid") == null) {
		session.setAttribute("uid", request.getParameter("uid"));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="sns_add.jsp">
		<%=session.getAttribute("uid")%>님: &nbsp;&nbsp; <input type="text"
			name="msg"><input type="submit" value="글 작성">
	</form>
	<hr>
	<%
		ArrayList<String> datas = (ArrayList) application.getAttribute("datas");
		if (datas != null) {
			for (String v : datas) {
				out.println(v + "<br>");
			}
		} else {
			out.println("<h3>채팅 기록이 없습니다!</h3>");
		}
		// 목록이 존재할때에는 그 목록 내용을 출력해주시고,
		// 존재xxx, "채팅 기록이 없습니다." 를 출력해주세요
	%>

</body>
</html>