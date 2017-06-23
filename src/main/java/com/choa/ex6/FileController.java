package com.choa.ex6;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.MultipartResolutionDelegate;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileDTO;
import com.choa.file.FileService;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;
import com.choa.util.SeDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController {
		
	
		//파일 다운
		@RequestMapping(value="fileDown", method=RequestMethod.GET)
		public ModelAndView fileDown(String fileName, String oriName, HttpSession session){
			String realPath = session.getServletContext().getRealPath("resources/upload");
			System.out.println("gogogogoogdnei");
			File f = new File(realPath, fileName);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("download");
			mv.addObject("oriName",oriName);
			mv.addObject("downloadFile", f);
			//뷰로 보내면 새로 만든 Download.java에 가짜뷰를 호출하게 sevlet-context.xml에 셋팅해줘야함
			
			return mv;
			
		}
		
		
		//스마트 에디터
		@RequestMapping(value="seUpload", method=RequestMethod.POST)
		public String seUpload(SeDTO seDTO, HttpSession session) throws Exception{
			
			//한글이름 파일은 되도록 업로드 X
			FileService fs = new FileService();
			
			return fs.seUpload(seDTO, session);
			
			/*//callback
			String callback = seDTO.getCallback();
			//callback_func
			String callback_func = seDTO.getCallback_func();
			//OriName
			String original_name = seDTO.getFiledata().getOriginalFilename();
			//defaultPath
			String defaultPath = session.getServletContext().getRealPath("resources/upload");
			
			File f = new File(defaultPath);
			
			//폴더가 존재하지 않을 경우
			if(f.exists()){
				f.mkdirs();
			}
			
			//디렉터리에 저장할 파일명
			String realName = UUID.randomUUID().toString()+"_"+original_name;
			
			//만들어진 파일을 디렉터리에 저장
			seDTO.getFiledata().transferTo(new File(f, realName));
			*/
			
			//
			//String file_result = "&bNewLine=true&sFilename="+original_name+"&sFileURL=/ex6/resources/upload/"+realName;
			
			
			//return "redirect:"+callback+"?callback_func="+callback_func+file_result;
			
			
			
			
			
			//파일 이름, 데이타 이름 어떤것인지 찍어봄
			/*Enumeration<Object> e = request.getParameterNames();
			
			while(e.hasMoreElements()){
				System.out.println(e.nextElement());
			}
			Iterator<String> it = request.getFileNames();
			
			while(it.hasNext()){
				System.out.println(it.next());
			}*/
			
		}
	
			@RequestMapping(value="fileUpload", method=RequestMethod.GET)
			public String fileUpload(){
				return "/file/fileUpload";
			}
			
			
			//파일 삭제
			@RequestMapping(value="fileDelete", method=RequestMethod.GET)
			public void fileDelete(String fileName, HttpSession session) throws Exception{
				// 실제로 만들떄는 서비스 객체를 이런식으로 만드는게 아님
				FileService f = new FileService();
				f.fileDelete(fileName, session);
			}
			
			
			
			//다중 파일업로드 인데 파라미터 이름을 모르거나 갯수가 유동적일대
			@RequestMapping(value="upload", method=RequestMethod.POST)
			public void upload(MultipartHttpServletRequest request){
				Iterator<String> it =request.getFileNames();
				ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();	//파일을 여러개 가져와서 배열에 담아준다.
				
				while(it.hasNext()){
					MultipartFile m = request.getFile(it.next());
					multi.add(m);
				}
				for(MultipartFile m : multi){
					System.out.println(m.getOriginalFilename());	//파일 원래 이름
				}
			}
			
			
			
			
			
			
			
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			//같은 파라미터 이름으로 넘어 오는 방법
			public void sameMultiFileUpload(MultipartFile [] f1){
				for(int i=0; i<f1.length;i++){
					System.out.println(f1[i].getOriginalFilename());
				}
			}
			//멀티파트 서블릿 리퀘스트사용  파라미터 이름이 같을때 f1으로 여러개 올릴 시 배열로 받기
			@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
			public void sameMultiFileUpload(MultipartHttpServletRequest request){
			List<MultipartFile> ar = request.getFiles("f1");
			for(MultipartFile f:ar){
			System.out.println(f.getOriginalFilename());
			}
			}
			//파라미터 이름이 같을때 f1으로 여러개 올릴 시 배열로 받기
			public void sameMultiFileUpload(SameMultiFileDTO dto){
				for(int i=0; i<dto.getF1().length;i++){
					System.out.println(dto.getF1()[i].getOriginalFilename());
				}
			}
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			//다중 파일 업로드 - 파라미터 이름이 다를 때
			@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
			public void multiFileUpload(MultiFileDTO multiFileDTO){ //다중파일 업로드 DTO 를 하나만들어서 그것을 사용함
				System.out.println(multiFileDTO.getF1().getOriginalFilename());
				System.out.println(multiFileDTO.getF2().getOriginalFilename());
			}
			public void multiFileUpload(MultipartFile f1, MultipartFile f2){
				System.out.println(f1.getOriginalFilename());
				System.out.println(f2.getOriginalFilename());
			}
			
			public void multiFileUpload(MultipartHttpServletRequest request){
				//2개를 꺼내야한다.
				MultipartFile f1 = request.getFile("f1");
				MultipartFile f2 = request.getFile("f2");
			}
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
			
			
				
				
			//@@@@@@@@@@@@@@@@@@@
			//단일 파일 업로드  기존에 쓰던 방법@@@
			//1번째방법
			/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)
			public void fileUpload(MultipartHttpServletRequest request){//
			}*/
			
			//2번째 방법
			@RequestMapping(value="fileUpload", method=RequestMethod.POST)
			public ModelAndView fileUpload(MultipartFile f1, HttpSession session) throws Exception{
				// 실제로 만들떄는 서비스 객체를 이런식으로 만드는게 아님
				FileService f = new FileService();
				String fileName = f.fileSave(f1, session);
				ModelAndView mv = new ModelAndView();
				mv.setViewName("file/FileView");
				mv.addObject("fileName", fileName);
				mv.addObject("oriName", f1.getOriginalFilename());
				return mv;
			}
//			//3번째 방법 
//			@RequestMapping(value="fileUpload", method=RequestMethod.POST)
//			public void fileUpload(FileDTO fileDTO){
//			}
			
			
}
