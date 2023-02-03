package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MyWebConfig;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	//c:/upload 파일 리스트 출력
	@GetMapping("/filelist")
	public ModelAndView downloadlist() {
		ModelAndView mv = new ModelAndView();
		File f = new File(MyWebConfig.savePath);
		String[] filelist = f.list();
		
		mv.addObject("filelist", filelist);
		mv.setViewName("upload/filelist");
		return mv;
	}
	
	@GetMapping("/filedownload")
	public void filedownload(String onefile, HttpServletResponse response) throws IOException {
		// onefile이라는 이름의 파일을 c:/upload 폴더에서 찾는다.
		File f = new File(MyWebConfig.savePath + onefile);
		int fileLength = (int) f.length();	// byte 단위의 길이
		
		// 응답할 컨텐츠가 다운로드 파일임을 명시
		response.setContentType("application/download");
		response.setContentLength(fileLength);
		response.setHeader("Content-Disposition" , "attachment;filename=\"" + onefile + "\"");
		
		// 다운로드 시작: 서버는 출력, 클라이언트는 입력
		OutputStream out = response.getOutputStream();
		FileInputStream fileInput = new FileInputStream(f);
		FileCopyUtils.copy(fileInput, out);	// 다운로드가 일어나는 곳, 위의 코드는 모드 설정
		fileInput.close();
		out.close();
	}
	
}
