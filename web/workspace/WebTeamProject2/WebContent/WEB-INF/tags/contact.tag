<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="type" %>

<!-- 코드의 유지보수에 대하여 확인하기! -->
<c:if test="${adminId==null}">
	<c:choose>	
		<c:when test="${type=='contact'}">
			<input name="portNum" type="text" class="form-control" disabled="disabled" value="로그인후에 글 등록이 가능합니다!">
			<input name="memberNum" type="text" class="form-control" placeholder="MemberNumber" required>
			<input name="memberEmail" type="email" class="form-control" placeholder="Your Email" required>
			<textarea name="contactContent" class="form-control" placeholder="Message" rows="4" required></textarea>
			<div class="contact-submit">
				<input type="submit" class="form-control submit" value="Send a message">
			</div>
		</c:when>
	</c:choose>
</c:if>
<c:if test="${adminId !=null}">
	<c:choose>	
		<c:when test="${type=='contact'}">
			<input name="portNum" type="text" class="form-control" placeholder="Portfolio Number" required>
			<input name="memberNum" type="text" class="form-control" placeholder="MemberNumber" required>
			<input name="memberEmail" type="email" class="form-control" placeholder="Your Email" required>
			<textarea name="contactContent" class="form-control" placeholder="Message" rows="4" required></textarea>
			<div class="contact-submit">
				<input type="submit" class="form-control submit" value="Send a message">
			</div>
		</c:when>
	</c:choose>
</c:if>