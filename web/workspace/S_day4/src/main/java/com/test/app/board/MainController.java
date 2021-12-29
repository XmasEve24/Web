package com.test.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.board.impl.BoardDAO;
@Controller
public class MainController{

	@RequestMapping(value="/main.do")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		BoardVO vo=new BoardVO(); // �˻��� ���� vo�Ķ���� ����������, ���� �����ȵȱ��
		BoardDAO dao=new BoardDAO();
		List<BoardVO> datas=dao.selectAll(vo);
		
		/*ModelAndView mav=new ModelAndView();
		mav.addObject("datas", datas);
		mav.setViewName("main");
		return mav;*/
		return "";
	}

}