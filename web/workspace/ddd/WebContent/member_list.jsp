<%@ page import="ddd.MemberDataBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ddd.MemberBean" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="mdb" class="ddd.MemberDataBean" scope="session"/>
<%--
여기 scope를 page로 바꾸었더니 데이터 유지가 왜 안될까?
 1. scope : page 영역의 mdb != scope : appliaction 영역의 mdb라서
 2. 그럼 main에서 Data를 저장하니까 main scope를 page로하면안됨? => 결과적으로 안됨
    -이유 : main에서 mdb를 scope : page 로 바꾸면 해당 객체는 page 넘어갈 시 없어진다. 최소 browser 이상
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>


    <tr>
        <td>이름</td>
        <td>아이디</td>
        <td>비밀번호</td>
    </tr>
    <br>
<%
    for (MemberBean v: mdb.getDatas()){

%>  <%-- mdb.getDatas 는 MemberBean 클래스의 Collector를 가지고있어서 for each 가능 --%>

       <tr>

           <td><%=v.getUname()%></>
           <td><%=v.getUid()%></>
           <td><%=v.getPassword()%></>
       </tr>
        <br>
<%
    }
    %>







</body>
</html>
