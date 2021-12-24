package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.admin.AdminDAO;

public class LoginAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// �α��ξ׼��� DB�κ��� select�� ���ؼ� �� ����� ������ �����ϴ��� Ȯ���ϴ� ������ �ʿ��ϴ�. 
		
		// �̿ϼ�
		 
		ActionInformation info = new ActionInformation();
		AdminDAO dao = new AdminDAO();
		
		
		info.setPath("login.jsp");
		info.setRedirect(false);
		
		return info;
	}
	
}
