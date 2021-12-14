<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" errorPage="error/error.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="dao" class="model.BoardDAO"/>
<jsp:useBean id="vo" class="model.BoardVO"/>
<jsp:setProperty property="*" name="vo"/>
<%
	// index 컨트롤러에게 main페이지 요청
	// C : main페이지는 데이터가 있어야되는데...
	// M 데이터 가져와
	// DB연동하여 데이터 가져옴
	// C main페이지 완성됬으니까 가져와서 보여줘
	// V main페이지 사용자에게 보여줌(브라우저V)
	
	String action = request.getParameter("action");

	if(action.equals("main")) {
		// 1. M에게서 데이터를 확보
		ArrayList<BoardVO> datas = dao.selectAll();
		// 2. V한테 데이터를 전달
		request.setAttribute("datas", datas); // 데이터를 보내는지에대한 여부
		// 메인페이지 보여줘
		pageContext.forward("main.jsp"); // 어디로 보내는지에대한 페이지정보
		
	} else if(action.equals("board")) {
		// 상세페이지 보여줘
		// 1. M에게서 데이터를 확보
		BoardVO data = dao.selectOne(vo);
		// 2. V한테 데이터를 전달
		request.setAttribute("data", data);
		pageContext.forward("board.jsp");

	} else if (action.equals("insert")) {
		System.out.println(vo); // ★★★★★
		if (dao.insert(vo)) {
		response.sendRedirect("controller.jsp?action=main");
	// C(insert) -> main.jsp버튼누르는 액션(조회액션) 
		}
		throw new Exception("insert 수행중에 오류발생");
		
	} else if (action.equals("delete")) {
		if (dao.delete(vo)) {
			response.sendRedirect("controller.jsp?action=main");
			// C(insert) -> main.jsp버튼누르는 액션(조회액션) 
		}
		throw new Exception("delete 수행중에 오류발생");
		
	} else if (action.equals("update")) {
		if (dao.update(vo)) { // CRUD 비즈니스 메서드의 인자로 VO객체를 사용하는것은 Spring식
			response.sendRedirect("controller.jsp?action=main");
		}
		throw new Exception("update 수행중에 오류발생"); 
	}
	else {
		out.println("<script>alert('action파라미터의 값이 올바르지않습니다!')</script>");
	}
%>