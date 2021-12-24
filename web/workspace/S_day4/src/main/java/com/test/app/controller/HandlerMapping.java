package com.test.app.controller;

import java.util.HashMap;
import java.util.Map;

import com.test.app.board.BoardController;
import com.test.app.board.MainController;
import com.test.app.member.LoginController;
import com.test.app.member.LogoutController;


public class HandlerMapping {
	
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		// �⺻ ������
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/main.do", new MainController());
		mappings.put("/board.do", new BoardController());
		
	}
	
	// ������� ��û�� ���� C��ü�� �˻�
	public Controller getController(String action) {
		return mappings.get(action);
	}
}
