package com.choa.ex6;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/memo/**")
public class MemoController {

	@Inject
	private MemoService memoService;
	
	@RequestMapping(value="memoList")
	public void memoList(){
	}
	
	@RequestMapping(value="memoView/{num}") //변수명
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") Integer num) throws Exception{ //@PathVariable - 경로변수명을 일치시킴
		MemoDTO memoDTO = memoService.boardView(num);
		return memoDTO;
	}
	
	@RequestMapping(value="getMemoList/{curPage}/{search}/{kind}", method=RequestMethod.GET)
	@ResponseBody //return 할 때 JSON 형식으로 데이터가 넘어감
	public List<MemoDTO> memoList(@PathVariable("curPage") int curPage, @PathVariable("search") String search, @PathVariable("kind") String kind ,Model model) throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setSearch(search);
		listInfo.setKind(kind);
		List<MemoDTO> ar = memoService.boardList();
		
		
		//기존 JSON 사용 방법
		/*JSONArray jar = new JSONArray();
		for(MemoDTO m : ar){
			JSONObject obj = new JSONObject();
			obj.put("num", m.getNum()+"");
			obj.put("writer",m.getWriter());
			obj.put("contents", m.getContents());
			obj.put("reg_date", m.getReg_date().toString());
			jar.add(obj);
			
		}*/
		//model.addAttribute("list", jar.toJSONString());
		
		return ar;
		//View가 아니라 data 형식으로 바로 body로 가게끔 해줌
		
	}
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model){
		int result = memoService.boardWrite(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		String message ="Fail";
		List<MemoDTO> ar =null;
		if(result > 0){
			 ar = memoService.boardList();
	
			//message="SUCCESS";
		}
		//model.addAttribute("message", memoDTO);
		//return "commons/ajaxResult";
		return ar;
	}
}
