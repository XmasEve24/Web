package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.board.BoardDAO;
import model.board.ReplyVO;

public class InsertRAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDAO dao = new BoardDAO();
		ReplyVO vo = new ReplyVO();
		vo.setBid(Integer.parseInt(request.getParameter("bid")));
		vo.setMid(request.getParameter("mid"));
		vo.setRmsg(request.getParameter("rmsg"));
		dao.insertR(vo);	
		
		String cnt=request.getParameter("cnt");
		int mcnt=2; 
		if(cnt!=null){
			mcnt=Integer.parseInt(cnt);
		}
		request.setAttribute("cnt", mcnt);
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		
		return forward;
	}

}
