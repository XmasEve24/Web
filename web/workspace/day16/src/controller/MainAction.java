package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.BoardSet;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cnt=request.getParameter("cnt");
		// int : parseInt(null xxx)
		int mcnt=2;
		if(cnt!=null) {
			mcnt=Integer.parseInt(cnt);
		}
		
		BoardDAO dao=new BoardDAO();
		ArrayList<BoardSet> datas=dao.selectAll(mcnt);
		request.setAttribute("datas", datas);
		request.setAttribute("cnt", mcnt);
		
		ActionForward forward=new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
/*
	String cnt=request.getParameter("cnt");
	// url 파라미터에 현재 게시글을 몇개까지 열람할수있는지에 대한 정보를 저장해야함!!!
	
	int mcnt=2; // 최초에는 2개의 게시글을 볼수있음
	if(cnt!=null){
		mcnt=Integer.parseInt(cnt);
	}
*/