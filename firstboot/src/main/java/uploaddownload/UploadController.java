package uploaddownload;

import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	// 업로드 폼 화면 보여주는 메서드
	@GetMapping("/fileupload")
	public String uploadForm() {
		return "uploaddownload/uploadForm";
	}
	
	// 업로드 처리 결과를 화면에 리턴해주는 메서드
	@PostMapping("/fileupload")
	public ModelAndView uploadResult(UploadDTO dto) throws IOException {
		String savePath = "c:/kdt/upload/"; 
		// 프로젝트 외부 경로(브라우저 url로 접근 불가)
		// http://localhost:8071/first/upload/xxx.파일
		
		String newFilename1 = null;
		MultipartFile file1 = dto.getFile1();
		if (!file1.isEmpty()) {
			String originalName1 = file1.getOriginalFilename();
			String ext1 = originalName1.substring(originalName1.lastIndexOf(".")); // 확장자
			String beforeExt1 = originalName1.substring(0, originalName1.lastIndexOf("."));
			newFilename1 = beforeExt1 + "(" + UUID.randomUUID().toString() + ")" + ext1;
			
			// file1에 포함된 내용을 경로에 복사해준다.
			file1.transferTo(new java.io.File(savePath + newFilename1));
		}
		
		String newFilename2 = null;
		MultipartFile file2 = dto.getFile2();
		if (!file2.isEmpty()) {
			String originalName2 = file2.getOriginalFilename();
			String ext2 = originalName2.substring(originalName2.lastIndexOf(".")); // 확장자
			String beforeExt2 = originalName2.substring(0, originalName2.lastIndexOf("."));
			newFilename2 = beforeExt2 + "(" + UUID.randomUUID().toString() + ")" + ext2;
			file2.transferTo(new java.io.File(savePath + newFilename2));
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadresult1", savePath + newFilename1 + " 저장했습니다.");
		mv.addObject("uploadresult2", savePath + newFilename2 + " 저장했습니다.");
		mv.setViewName("uploaddownload/uploadResult");
		return mv;
	}
	
}

// - 파일 업로드 기능
// ex) 서버로 이력서 파일 전송하기, 게시판 첨부파일, 쇼핑몰 이미지
// 업로드 : 클라이언트가 서버로 파일을 전송하는 것.
// 다운로드 : 서버에서 클라이언트로 파일을 전송하는 것.

// 폼 태그만 전송방식을 설정할 수 있고 나머지 태그(a)들은 get 방식으로 전송한다.
// 파일을 전송할 때 폼 태그는 post 방식으로 전송해야 한다.
// type=file이면 파일명, 길이, 내용, 확장자 등의 정보가 모두 전송된다.
// form태그 enctype 속성 : "multipart/form-data"
// <form action="memberlist" method="post" enctype="multipart/form-data">
// <input type=file name="f" />
// <input type=text name="name" />

// MultipartFile은 파일의 정보와 그 이외의 전송 데이터를 모두 갖고 있다.
// @PostMapping("/memberlist")
// ...(MultipartFile f)
// f.getOriginalFileName()
// f.transfer(자바파일객체("client.txt"))

// - get vs post
// http 프로토콜이 요청 정보 포함하고 있다.
// 시작라인은 다음에 요청헤더가 오기 때문에 길이 제한이 있다(텍스트).
// 요청바디는 다음에 아무것도 오지 않아서 길이 제한이 없다(파일).
// 시작라인 : uri(+get 데이터), http버전, get/post 방식
// 요청헤더 : 브라우저, os, 쿠키 정보 
// 요청바디 : 실제 서버로 전송하는 데이터(post), 여러 part로 구성하여 전송.

// jakart.servlet.http.HttpServletRequest 객체 : http 프로토콜 요청
// request.getParameter() : 파일을 읽을 수 없다.
// 파일 업로드 지원 메소드가 없다.
// 요청 바디 부분을 스트림으로 읽어올 수 없다.
// 따라서 MultipartFile 객체를 사용하여 파일을 읽어온다(라이브러리).

// - 파일 업로드 폼
// 설명 input : text 타입, desc
// 업로더 input : text 타입, uploader
// 업로드 파일1 input : file 타입, f1
// 업로드 파일2 input : file 타입, f2

// - 컨트롤러
// 메소드(String desc, String uploader, 
//     MultipartFile f1, MultipartFile f2) ---> X
// 메소드(UploadDTO dto) ---> O

// class UploadDTO {
// 	   String desc, uploader;
//     MultipartFile f1, f2;
// }

// 실제 서버 내부에 파일 형태로 보관하고 있어야 한다.
