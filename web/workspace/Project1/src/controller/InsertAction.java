package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class InsertAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO(); 
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		vo.setTitle(request.getParameter("title"));
		dao.insert(vo);
			
		ArrayList<BoardVO> datas = dao.selectAll(); // M���� ����(dao���� ����Ͻ��޼��带 ����)
		request.setAttribute("datas", datas);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp"); // -> main.do�� ���濹��
		forward.setRedirect(false);
		
		return forward;
	}

}
