package com.test.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.app.board.impl.BoardDAO;
import com.test.app.controller.Controller;

public class MainController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO vo=new BoardVO(); // �˻��� ���� vo�Ķ���� ����������, ���� �����ȵȱ��
		BoardDAO dao=new BoardDAO();
		List<BoardVO> datas=dao.selectAll(vo);
		
		HttpSession session=request.getSession(); // ������ �������� ó��
		session.setAttribute("datas", datas);
		return "main"; // VR�� viewNameó��
	}

}