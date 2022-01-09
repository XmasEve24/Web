package com.test.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.board.impl.BoardDAO;
import com.test.app.controller.Controller;

public class MainController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		BoardVO vo=new BoardVO(); // 검색을 위해 vo파라미터 제작했으나, 현재 구현안된기능
		BoardDAO dao=new BoardDAO();
		List<BoardVO> datas=dao.selectAll(vo);
		
		HttpSession session=request.getSession(); // 지금은 세션으로 처리
		session.setAttribute("datas", datas);
		return "main"; // VR가 viewName처리
	}

}