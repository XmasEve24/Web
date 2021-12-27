package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberLoginAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		  ActionInformation info = new ActionInformation();
		  MemberDAO dao=new MemberDAO();
	      MemberVO vo=new MemberVO();
	      vo.setMemberId(request.getParameter("Id"));
	      vo.setMemberPw(request.getParameter("Pw"));
	      
	      if(dao.memberLogin(vo)) {
	         HttpSession session=request.getSession();
	         session.setAttribute("adminId", vo.getMemberId());
		     session.setAttribute("adminName", vo.getMemberName());
			 info.setPath("main.do");
		     info.setRedirect(false);	    
	      }
	      else {
	    	System.out.println("ȸ�� �α��� ����");
			info.setPath("login.jsp");
			info.setRedirect(true);
	      }	      
	      return info;
	}
}
