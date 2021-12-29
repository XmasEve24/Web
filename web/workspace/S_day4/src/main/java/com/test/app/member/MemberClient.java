package com.test.app.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.app.member.impl.MemberDAO;

public class MemberClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");
			
		// �α��� ȭ�鿡�� ID,PW�� �Է��ϰ� �α��� ��ư�� ����
		MemberVO vo=new MemberVO();
		vo.setMid("kim");
		vo.setPassword("1234");
		
		MemberVO data=ms.selectOne(vo);
		if(data==null) {
			System.out.println("�α��� ����!");
		}
		else {
			System.out.println(" ["+data.getRole()+"]"+data.getName()+"��,�ݰ����ϴ�!:D");
		}
	
		factory.close();
	}
}
