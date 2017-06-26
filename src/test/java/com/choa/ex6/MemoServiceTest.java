package com.choa.ex6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;

public class MemoServiceTest extends MyAbstractTest{

	@Inject
	private MemoService memoService;
	
	
	public void list(){
		List<MemoDTO> ar =memoService.boardList();
		
		assertNotEquals(0, ar.size());
	}
	
	public void view(){
		MemoDTO memoDTO = memoService.boardView(2);
		
		assertNotNull(memoDTO);
	}
	
	
	public void write(){
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setContents("c33h235322");
		memoDTO.setWriter("IU3322");
		
		int result = memoService.boardWrite(memoDTO);
		assertEquals(1, result);
	}
	@Test
	public void update(){
		MemoDTO memoDTO = new MemoDTO();
		
		memoDTO.setNum(2);
		memoDTO.setContents("c22222");
		int result = memoService.boardUpdate(memoDTO);
		assertEquals(1, result);
	}
	
	public void delete(){
		
	}
}
