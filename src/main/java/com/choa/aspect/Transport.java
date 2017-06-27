package com.choa.aspect;

import org.springframework.stereotype.Component;

//핵심 로직
@Component
public class Transport {

	public void bus(){
		System.out.println("자리 뺏기");
		System.out.println("옆사람 핸드폰 보기");
		System.out.println("BBBBBBBBBBBBBBB");
		
	}
	
	public void subway(){
		System.out.println("두리번 거리기");
		System.out.println("리니지M 하기");
		System.out.println("SSSSSSSSSSSSSS");
		
	}
	
	
	
	
}
