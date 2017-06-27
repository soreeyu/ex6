package com.choa.ex6;

import static org.junit.Assert.assertNotEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyAbstractTest{

	@Inject
	private TableService tableService;
	
	@Test
	public void Test() throws Exception{
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(2);
		tableADTO.setTitle("t2");
		tableADTO.setWriter("choa2");
		
		int result = tableService.insertTable(tableADTO, 1);
		assertNotEquals(0, result);
	}
}
