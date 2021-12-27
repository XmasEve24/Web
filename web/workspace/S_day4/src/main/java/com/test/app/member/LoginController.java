package com.test.app.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setPassword(request.getParameter("password"));
		MemberDAO dao=new MemberDAO();
		MemberVO data=dao.selectOne(vo);
		
		ModelAndView mav = new ModelAndView();
		if(data!=null) {
			mav.addObject("member", data);
			mav.setViewName("main.do");
		}
		else {
			mav.setViewName("login.jsp");
		}
		return mav;
	}

}
