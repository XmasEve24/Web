<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "ko";
	String password = "1520";

	String sql_insert = "insert into board values((select nvl(max(bid),0)+1 from board),?,?)"; // pstmt
	String sql_selectAll = "select * from board";

	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		Class.forName(driver);

		conn = DriverManager.getConnection(url, user, password);
		
		if(request.getParameter("writer")!=null){
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, request.getParameter("writer"));
			pstmt.setString(2, request.getParameter("content"));
			pstmt.executeUpdate();
		}
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post">
		작성자: <input type="text" name="writer"> 내용: <input type="text" name="content"> <input type="submit" value="게시글 등록">
</form>

<hr>

<h2>게시글 목록</h2>
<%
	pstmt = conn.prepareStatement(sql_selectAll);
	ResultSet rs = pstmt.executeQuery();
	while(rs.next()){
		out.println(rs.getInt("bid") + ". " +rs.getString("writer") + "님 : [" + rs.getString("content") + "]<br>");
	}
	rs.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
%>
</body>
</html>