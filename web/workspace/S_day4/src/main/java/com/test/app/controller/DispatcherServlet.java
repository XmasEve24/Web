package com.test.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.member.MemberVO;
import com.test.app.member.impl.MemberDAO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String action=uri.substring(uri.lastIndexOf("/"));
		System.out.println(action);
		if(action.equals("/login.do")) {
			MemberVO vo=new MemberVO();
			vo.setMid(request.getParameter("mid"));
			vo.setPassword(request.getParameter("password"));
			MemberDAO dao=new MemberDAO();
			MemberVO data=dao.selectOne(vo);
			if(data!=null) {
				// 세션에 정보 저장
				response.sendRedirect("main.jsp");
			}
			else {
				response.sendRedirect("login.jsp");
			}
			// 1. request.getParameter()
			// 사용자가 입력한 정보들을 추출
			
			// 2. VO setter
			
			// 3. DAO
			// 비즈니스 메서드 수행
			
			// 4. View를 지정
			// 로그인성공시, main.jsp
			// 로그인실패시, login.jsp
		}
		else if(action.equals("/logout.do")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		else if(action.equals("/insertBoard.do")) {
			
		}
		else if(action.equals("/updateBoard.do")) {
			
		}
		else if(action.equals("/deleteBoard.do")) {
			
		}
		else if(action.equals("/main.do")) {
			
		}
		else if(action.equals("/board.do")) {
			
		}
	}
}
