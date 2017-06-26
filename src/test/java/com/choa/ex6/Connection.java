package com.choa.ex6;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Connection extends MyAbstractTest{

	@Inject
	private SqlSession sqlSession;
	
	@Test
	public void test(){
		
		assertNotNull(sqlSession);
	}
}
