<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="rmid" %>
<%@ attribute name="rid" %>

<c:if test="${rmid==mid}">
	<a href="board_controller.jsp?action=deleteR&cnt=${cnt}&rid=${rid}">[삭제]</a>
</c:if>