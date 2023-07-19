package uploaddownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	
	@RequestMapping("/filedownloadlist")
	public ModelAndView downloadList () {
		// c:/kdt/upload/파일이름 모델 저장
		// 파일 시스템 정보 : 폴더와 파일을 포함
		File f = new File("c:/kdt/upload/");
		// 파일 이름 String 배열로 반환
		String[] filearray = f.list(); 
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("filearray", filearray);
		mv.setViewName("uploaddownload/downloadlist");
		return mv;
	}
	
	@RequestMapping("/filedownloadresult")
	public void downloadResult (String filename, HttpServletResponse response) throws IOException {
		File downloadFile = new File("c:/kdt/upload/" + filename); // 다운받을 파일
		filename = URLEncoder.encode(filename, "UTF-8"); // 파일 이름 깨짐 방지용 인코딩
		// 다운로드 설정
		response.setContentType("application/download");
		response.setContentLength((int) (downloadFile.length()));
		response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
		
		// 다운로드 실행
		// 파일 응답할 객체 생성
		OutputStream out = response.getOutputStream();
		// 다운로드할 파일 객체 생성
		FileInputStream fin = new FileInputStream(downloadFile);
		// 브라우저로 파일 출력
		FileCopyUtils.copy(fin, out);
		
		fin.close();
		out.close();
	}
}

// - 파일 다운로드 기능
// pom.xml 추가 라이브러리는 없다.
// servlet-context.xml에 resource 태그 추가한다.
// response.setContentType("다운로드할 경로"); // application/download
// response.setContentLength("파일 길이(총 byte)");
// response.setHeader("Component-Disposition", "attachment;filename=\"파일명\"");

// OutputStream out = response.getOutputStream();
// FileInputStream fin = new FileInputStream(다운로드할 File 객체);
// FileCopyUtils.copy(fin, out);
// fin.close(); out.close();
