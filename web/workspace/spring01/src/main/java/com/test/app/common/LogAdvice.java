package com.test.app.common;

import org.aspectj.lang.JoinPoint;

public class LogAdvice {
	
	// JP: 스프링컨테이너가 new JP() (==jp객체생성)
	// 현재 수행되는 비즈니스메서드 정보를 셋팅
	
	public void printLog(JoinPoint jp) {
		System.out.println("JP실습중..");
		String coreMethod = jp.getSignature().getName(); // 메서드 시그니쳐
		System.out.println("처리중인 비즈니스 메서드명: " + coreMethod);
		Object[] args=jp.getArgs();
		System.out.println("args들: ");
		for(Object v:args) {
			System.out.println(v+" ");
		}
		System.out.println();
	}
}
