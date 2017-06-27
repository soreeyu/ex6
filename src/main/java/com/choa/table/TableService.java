package com.choa.table;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class TableService {

	@Inject
	private TableDAO tableDAO;
	
	//자동 롤백 스프링 제공
	public int insertTable(TableADTO tableADTO, int num) throws Exception{
		tableDAO.insertTableA(tableADTO);
		TableBDTO tableBDTO = new TableBDTO();
		tableBDTO.setWriter(tableADTO.getWriter());
		tableBDTO.setPoint(10);
		tableBDTO.setNum(num);
		
		return tableDAO.insertTableB(tableBDTO);
	}
}
