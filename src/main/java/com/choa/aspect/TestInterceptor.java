package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;

public class TestInterceptor extends HandlerInterceptorAdapter{//HandlerInterceptorAdapter 상속

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("controller 나온 후");
		Map<String, Object> map = modelAndView.getModel();
		Object list = map.get("list");
		Object listInfo = map.get("info");
		Object board = map.get("board");
		//modelAndView.addObject(attributeName, attributeValue); 추가도 가능
		System.out.println(((List<BoardDTO>)list).get(0).getWriter());
		System.out.println(((ListInfo)listInfo).getCurBlock());
		System.out.println(board);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("controller 가기전");
		
		
		return true; //컨트롤러로 값을 보내고 싶으면 true 아니면 false
	} 
	
	
	

}
