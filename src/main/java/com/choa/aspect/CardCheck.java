package com.choa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//공통 로직
@Component
@Aspect				//이것이 aspect이다라고 정의
public class CardCheck {
	
	@Before("execution(* com.choa.aspect..Trip.*(..))")
	public void reservation(){
		System.out.println("예약 완료");
		
		System.out.println("=============================");
		
	}
	
	
	@Around("execution(* com.choa.aspect..Transport.*(..))")
	public Object  check(ProceedingJoinPoint join){ //join  = bus 
		System.out.println("Card Check IN");
		
		Object obj = null;
		
		try {
			obj = join.proceed();					//버스 실행
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Card Check OUT");
		return obj;
	}

}
