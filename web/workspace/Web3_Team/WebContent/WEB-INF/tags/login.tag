<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
   <c:when test="${memberID == null}">
   	 <form method="post" action="login.jsp">
      <input type="submit" value="LOGIN">
      </form>
   </c:when>
   <c:otherwise>
      <form method="post" action="logout.do">
      <input type="submit" value="LOGOUT">
      </form>
   </c:otherwise>
</c:choose>