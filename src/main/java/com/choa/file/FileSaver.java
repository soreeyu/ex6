package com.choa.file;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//세이브 전용 클래스
public class FileSaver {
	
	public String filesave(String realPath, String oriName, byte [] fileData) throws Exception{
		File file = new File(realPath);
		
		if(!file.exists()){
			file.mkdirs();
		}
		//upload 폴더에 저장되는 실제 파일 이름
		String fileName = UUID.randomUUID().toString()+"_"+oriName;
		File taget = new File(file, fileName);
		FileCopyUtils.copy(fileData, taget);
		
		return fileName;
		
	}
	public String filesave(String realPath,MultipartFile m) throws Exception{
		System.out.println(realPath);
		File file = new File(realPath);
		if(!file.exists()){
			file.mkdirs();
		}
//		String fileName = UUID.randomUUID().toString()+"_"+m.getOriginalFilename(); 
						//[   UUID만들기     ]
		//중복만 되지 않게 하면된다.UUID 쓰지말고  밀리세컨을 이용하여 
		Calendar c = Calendar.getInstance();
		String fileName = c.getTimeInMillis()+"_"+m.getOriginalFilename(); //밀리세컨을 이용하여 밀리세컨시간+파일이름.
		File target = new File(file,fileName);
		m.transferTo(target); //transferTo : 누구한테 전달하겠다. (target)을 썻으니 타겟쪽에 전달하겠다.
		
		return fileName;
	}
}
