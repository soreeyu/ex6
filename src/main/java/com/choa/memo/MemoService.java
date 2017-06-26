package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemoService {

	@Inject
	private MemoDAO memoDAO;
	
	//list
	public List<MemoDTO> boardList(){
		return memoDAO.boardList();
	}
	//view
	public MemoDTO boardView(int num){
		return memoDAO.boardView(num);
	}
	//write
	public int boardWrite(MemoDTO memoDTO){
		return memoDAO.boardWrite(memoDTO);
	}
	
	//update
	public int boardUpdate(MemoDTO memoDTO){
		return memoDAO.boardUpdate(memoDTO);
	}
	
	//delete
	public int boardDelete(int num){
		return memoDAO.boardDelete(num);
	}
}
