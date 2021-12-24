package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.controller.Controller;
import com.test.app.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		MemberDAO dao=new MemberDAO();
		MemberVO data=dao.selectOne(vo);
		if(data!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("member", data);
			return "main.do";
		}
		else {
			return "login.jsp";
			// VR : 확장자(.jsp등) 여부확인 -> .jsp 자동추가
		}
		
	}

}
