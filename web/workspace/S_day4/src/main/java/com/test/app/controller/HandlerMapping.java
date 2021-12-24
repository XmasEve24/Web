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
		// 기본 생성자
		mappings=new HashMap<String,Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/main.do", new MainController());
		mappings.put("/board.do", new BoardController());
		
	}
	
	// 사용자의 요청을 보고 C객체를 검색
	public Controller getController(String action) {
		return mappings.get(action);
	}
}
