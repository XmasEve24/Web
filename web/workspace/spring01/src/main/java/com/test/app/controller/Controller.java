package com.test.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
	// : req, res 사용자의 요청정보를 받아서 -> 화면 네비게이션
}
