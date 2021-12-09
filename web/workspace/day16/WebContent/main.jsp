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
.h {
	
}
</style>
<script type="text/javascript">
	function newMember(){
		window.open('new.jsp', '새창으로 회원가입', 'width=500, height=300, menubar=no, status=no, toolbar=no');
	}
</script>
</head>
<body>

<h1>My Application! :D</h1>

<ul>
	<li>로고</li>
	<li><a href="javascript:newMember()">회원가입</a></li>
	<li><mytag:login /></li>
</ul>

<hr>
<div class="h">
<form action="board_controller.jsp?action=insertB" method="post">
<%-- <c:choose>
	<c:when test="${mid != null}">
		<input type="hidden" name="mid" value="${mid}">
		<input type="text" name="msg">
		<input type="submit" value="글 등록">
	</c:when>
	<c:otherwise>
		<input type="text" name="msg" disabled="disabled" value="로그인후에 글 등록이 가능합니다!" size="40">
	</c:otherwise>
</c:choose> --%>
	<input type="hidden" name="mid" value="${mid}">
	<mytag:write type="board"/>
</form>
</div>
<hr>


<c:forEach var="v" items="${datas}">
	<div class="a">
		<c:set var="bvo" value="${v.board}" />
		${bvo.mid}님의 글: ${bvo.msg} [좋아요: ${bvo.favcnt} | 댓글: ${bvo.rcnt}] <mytag:removeB rmid="${bvo.mid}" bid="${bvo.bid}" />
		<div class="b">
			<br>
			<form action="board_controller.jsp?action=insertR&cnt=${cnt}" method="post">
				<input type="hidden" name="mid" value="${mid}">
				<input type="hidden" name="bid" value="${bvo.bid}">
				<mytag:write type="reply"/>
			</form>
			<br>
			<c:forEach var="vv" items="${v.rdatas}">
				${vv.mid}님의 댓글: ${vv.rmsg} <mytag:removeR rmid="${vv.mid}" rid="${vv.rid}" /> <br>
			</c:forEach>
		</div>
	</div>
	<br>
</c:forEach>

<a href="board_controller.jsp?action=main&cnt=${cnt+2}">[더보기]</a>

</body>
</html>