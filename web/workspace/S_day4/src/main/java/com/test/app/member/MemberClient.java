package com.test.app.member;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;

public class MemberClient {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms = (MemberService)factory.getBean("memberService");
		
		MemberVO vo=new MemberVO();
		vo.setMid("ko");
		vo.setPassword("1234");
		MemberVO data = ms.selectOne(vo);
		if(data==null) {
			System.out.println("로그인 실패!");
		}
		else {
			System.out.println("["+data.getRole()+"]"+data.getName()+"님, 반갑습니다!");
		}
		factory.close();
	}
}
