package com.choa.file;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	
	private String name;
	private MultipartFile f1; //변수명은 파라미터 이름과 동일
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getF1() {
		return f1;
	}
	public void setF1(MultipartFile f1) {
		this.f1 = f1;
	}
	
	
}
