package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class BoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardVO vo = new BoardVO(); // controller.jsp 7������
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		BoardDAO dao = new BoardDAO(); // controller.jsp 6������
		
		BoardVO data = dao.selectOne(vo); // controller.jsp 30������
		request.setAttribute("data", data); // 32������
		ActionForward forward = new ActionForward(); // 33������
		forward.setPath("board.jsp"); // 33
		forward.setRedirect(false);  //  33
		
		return forward;
	}

}
