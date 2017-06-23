package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//뷰페이지로 가지 않으려면 AbstractView 뷰역할을 하는 이 클래스를 상속받아야함
public class Download extends AbstractView{

	public Download(){
		setContentType("application/download;charset=UTF-8");
		
	}

	
	//다운로드!!!!!!!!!!!!!
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//
		File f = (File)model.get("downloadFile");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());
		
		//원래 이름으로 다운 하는 방법 1
		String oriName= (String)model.get("oriName");
		
		//원래 이름으로 다운 하는 방법 2
		String fileName = URLEncoder.encode(f.getName(), "UTF-8");
		fileName = fileName.substring(fileName.lastIndexOf("_")+1);
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fi = null;
		
		fi = new FileInputStream(f);
		FileCopyUtils.copy(fi, out);
		
		fi.close();
		out.close();
	}
	
}
