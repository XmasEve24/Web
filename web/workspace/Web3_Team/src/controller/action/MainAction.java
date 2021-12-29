package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionInformation;
import model.admin.AdminVO;

public class MainAction implements Action{

	@Override
	public ActionInformation execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ������ �����ִ� ��� ȭ���� �ƴϱ� ������ ������ �̵��� ���� ������ ��ȯ�� ���ָ� �ȴ�. 
		ActionInformation info = new ActionInformation();
		
		info.setPath("main.jsp");
		info.setRedirect(false);
		
		return info;
	}
	
}
