package com.choa.ex6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;

public class MemoDAOTest extends MyAbstractTest{

	
	
	@Inject
	private MemoDAO memoDAO;


	
	
	public void Insert(){
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setContents("choachoc22");
		memoDTO.setWriter("IU22");
		
		int result = memoDAO.boardWrite(memoDTO);
		assertEquals(1, result);
	}
	
	public void view(){
		MemoDTO memoDTO =memoDAO.boardView(2);
		System.out.println(memoDTO.getWriter());
		System.out.println(memoDTO.getContents());
	}
	
	public void list(){
		List<MemoDTO> ar = memoDAO.boardList();
		
		assertEquals(2, ar.size());
	}
	
	public void update(){
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setNum(2);
		memoDTO.setContents("choachoc222");
		
		
		int result = memoDAO.boardUpdate(memoDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void delete(){
		int result =memoDAO.boardDelete(3);
		
		assertEquals(1, result);
	}
	
}
