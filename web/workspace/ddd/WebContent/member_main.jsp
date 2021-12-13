<%--
  Created by IntelliJ IDEA.
  User: parkjiwan
  Date: 2021-12-06
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%
    request.setCharacterEncoding("UTF-8");
%>

<%--
    scope.setAttribute("name", name) : 속성을 set하다. scope 영역에 "name" : name 으로 값 정의함
    scope.getAttribute("name") : 속성을 get하다. scope 영역의 "name"에 저장된 Data를 확인한다.

    1)입력받은 데이터 -> MemberBean DataAdapter로 받는 방법
        -improt : MemberBean.Class 이후 인스턴스 생성 및 객체 생성
        -jsp:useBean : 객체 이름(id) 와 import할 class경로(class) 데이터 유지 범위(scope) 입력 => 클래스 import 및 객체(id) 생성
    2)데이터 페이지로 불러오기
        -getBeanVar
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<jsp:useBean id="mb" class="ddd.MemberBean"/>
<jsp:setProperty name="mb" property="*"/>
<jsp:useBean id="mdb" class="ddd.MemberDataBean" scope="session"/>
<%--mdb는 scope가 page이기 떄문에 페이지 넘어갈 시 메모리에서 해제 => 못씀--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="member_search.jsp">
    검색할 이름 입력:<input type="text" name="sname">
    <input type="submit" value="검색하기">
</form>

<table border="1">
    <tr>
        <td>이름</td>
        <td><%=mb.getUname()%></td>
    </tr>
    <tr>
        <td>아이디</td>
        <td><%=mb.getUid()%><td>
    </tr>
    <tr>
        <td>비밀번호</td>
        <td><%=mb.getPassword()%></td>
    </tr>
    <tr>
        <a href="member_list.jsp">멤버 리스트 확인하기</a>
    </tr>
</table>

<%

        mdb.add(mb); // 최근 받았던 Data를 mdb에 저장

        System.out.println("\n이름: " + mb.getUname() + "\n아이디: " + mb.getUid() + "\n비밀번호: " + mb.getPassword()); // 최근에 받았던 데이터 로그
%>
</body>
</html>
