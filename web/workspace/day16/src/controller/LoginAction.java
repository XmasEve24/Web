package controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.member.MemberDAO;
import model.member.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		
		ActionForward forward=null;
		if(dao.selectOne(vo)) {
			HttpSession session=request.getSession();
			session.setAttribute("mid", vo.getMid());
			forward=new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			// html, CSS, JS 변경했는데도 변화가없을때
			// -> 기존데이터를 참고해서 화면을 구성
			// => 인터넷기록을 삭제
			PrintWriter out=response.getWriter();
			out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
		}
		return forward;
	}

}
/*
if(mdao.selectOne(mvo)){
	session.setAttribute("mid", mvo.getMid());
	response.sendRedirect("board_controller.jsp?action=main");
}
else{
	out.println("<script>alert('로그인 실패!');history.go(-1);</script>");
}
*/