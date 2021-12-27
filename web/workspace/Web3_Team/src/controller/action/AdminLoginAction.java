package controller.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionInformation;
import model.admin.AdminDAO;
import model.admin.AdminVO;

public class AdminLoginAction implements Action{
	
	private boolean flag;

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// �α��ξ׼��� DB�κ��� select�� ���ؼ� �� ����� ������ �����ϴ��� Ȯ���ϴ� ������ �ʿ��ϴ�. 	
		ActionInformation info = new ActionInformation();
		AdminDAO dao = new AdminDAO();
		AdminVO vo = new AdminVO();
		
		vo.setAdminId(request.getParameter("Id"));
		vo.setAdminPw(request.getParameter("Pw"));
		
		if(dao.adminLogin(vo)) {
			HttpSession session=request.getSession();
	        session.setAttribute("adminId", vo.getAdminId());
	        session.setAttribute("adminName", vo.getAdminName());
			info.setPath("main.do");
			info.setRedirect(false);
			setFlag(true);
		}
		else {
			System.out.println("������ �α��� ����");
			info.setPath("login.jsp");
			info.setRedirect(true);
			setFlag(false); // �α��� ���� �� flag == false 
		}
			
		return info;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
