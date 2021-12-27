package com.test.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.app.board.impl.BoardDAO;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo=new BoardVO(); // �˻��� ���� vo�Ķ���� ����������, ���� �����ȵȱ��
		BoardDAO dao=new BoardDAO();
		List<BoardVO> datas=dao.selectAll(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main,jsp");
		return mav;
	}

}