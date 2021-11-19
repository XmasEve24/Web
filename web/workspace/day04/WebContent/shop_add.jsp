<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
    <%
    	request.setCharacterEncoding("UTF-8");
    	String product=request.getParameter("product");
    	
    	ArrayList<String> datas=(ArrayList)session.getAttribute("datas");
    	if(datas==null) {  
    		// 장바구니가 매번생성되는것xxx
    		// 처음 장바구니에 상품을 추가할때만 1회 생성됨
	    	datas = new ArrayList<String>(); // 장바구니 만듬
	    	session.setAttribute("datas", datas);
    	}
    	
    	datas.add(product);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
		alert("<%=product%>가 장바구니에 추가되었습니다. !");
		history.go(-1); // == 뒤로가기
	</script>
</body>
</html>