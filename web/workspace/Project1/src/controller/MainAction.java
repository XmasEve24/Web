package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class MainAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardVO> datas = dao.selectAll(); // M과의 연동(dao에서 비즈니스메서드를 수행)
		request.setAttribute("datas", datas);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp"); // 경로
		forward.setRedirect(false); // 방식
		
		return forward;
	}

}
