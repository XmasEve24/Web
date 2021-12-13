
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="mdb" class="ddd.MemberDataBean"/>
<jsp:useBean id="mb" class="ddd.MemberBean"/>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%
    String sname = request.getParameter("sname");
    System.out.println("받은 입력값:"+sname);//  member_main에서 "sname으로 데이터 전송
    mb = mdb.search(sname); //데이터 어뎁터로 mb라는 어뎁터  생성 후 데이터 가져온 후 serach
    System.out.println(mb);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>회원 정보</h1>
<tr>
    <td>이름<</td>
    <td><%=mb.getUname()%></td>
</tr>
<tr>
    <td>아이디</td>
    <td><%=mb.getUid()%></td>
</tr>
<tr>
    <td>비밀번호</td>
    <td><%=mb.getPassword()%></td>
</tr>

</body>
</html>
