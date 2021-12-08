<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a {
	color: black;
	text-decoration: none;
}
a:hover {
	color: red;
}

.a {
	background-color: lightpink;
}
.b {
	background-color: lightblue;
}
</style>
<script type="text/javascript">
	function newMember() {
		window.open('new.jsp', '새창으로 회원가입', 'width=500, height=300, menubar=no, status=no, tollbar=no');
	}
</script>
</head>
<body>

<h1>My Application! :D</h1>

<ul>
	<li>로고</li>
	<li><a href="javascript:newMember()">회원가입</a></li>
	<li><mytag:login/></li>
</ul>

<c:forEach var="v" items="${datas}">
	<div class="a">
		<c:set var="bvo" value="${v.board}" />
		${bvo.mid}님의 글: ${bvo.msg} [좋아요: ${bvo.favcnt} | 댓글: ${bvo.rcnt}]  <mytag:removeB rmid="${bvo.mid}" bid="${bvo.bid}" />
		<div class="b">
			<c:forEach var="vv" items="${v.rdatas}">
				${vv.mid}님의 댓글: ${vv.rmsg} <mytag:removeR rmid="${vv.mid}" bid="${vv.bid}"/> <br>
			</c:forEach>
		</div>
	</div>
	<br>
</c:forEach>

<a href="board_controller.jsp?action=main&cnt=${cnt+2}">[더보기]</a>

</body>
</html>