package com.choa.memo;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDAO {

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="MemoMapper.";
	
	
	//List
	public List<MemoDTO> boardList(){
		return sqlSession.selectList(NAMESPACE+"list");
	}
	//view
	public MemoDTO boardView(int num){
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}
	//insert
	public int boardWrite(MemoDTO memoDTO){
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
	}
	//update
	public int boardUpdate(MemoDTO memoDTO){
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	//delete
	public int boardDelete(int num){
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
}
