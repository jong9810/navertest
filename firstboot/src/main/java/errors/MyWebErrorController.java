package errors;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyWebErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute
			(RequestDispatcher.ERROR_STATUS_CODE);
		System.out.println("오류 코드 : " + status); // 404, 405 ...
		System.out.println("오류 메시지 : " + request.getAttribute
			(RequestDispatcher.ERROR_MESSAGE));
		System.out.println("파라미터 정보 : " + request.getAttribute
			(RequestDispatcher.FORWARD_QUERY_STRING));
		System.out.println("오류 파일 : " + request.getAttribute
			(RequestDispatcher.ERROR_REQUEST_URI));
		
		return "errors/" + status.toString();
	}
}

// - 32장 spring boot
// 1) 설정 간소화
// 2) xml 파일을 최소화하여 spring boot에 내장하거나 
// application.properties 파일에 정의하도록 한다.
// src/main/resources.application.properties
// 3) jsp 기본뷰로 설정되어 있지 않다.
// 4) servlet, jsp, jstl 기본 라이브러리가 내장되어 있지 않다.
// 5) tomcat 서버 내장되어 있어 실행된다.
// 6) maven - pom.xml에 필요한 라이브러리 추가할 수 있다.
// 7) ajax, fileupload : 추가 라이브러리를 지정할 필요 없다(내장되어 있음).
// 8) 스프링 부트는 url에 포트번호까지만 명시하면 컨텍스트로 연결된다.
// 9) 예외가 발생하면 자동으로 컨텍스트 url/error로 연결된다.
// 

// - 디렉토리
// 1) src/main/java
// 컨트롤러, dto, dao, service 등
// 패키지명 : 스프링부트 메인 클래스(@SpringBootApplication)
// 서버 시작되면 스프링부트 메인 클래스 패키지는 자동으로 스캔한다.

// 2) src/main/resources
// # application.properties
// server.port = 서버 포트 지정
// spring.mvc.view.prefix = 뷰 파일들이 저장될 경로 지정
// spring.mvc.view.suffix = 뷰 파일 확장자 지정
// # static 폴더 : 정적인 파일들(js, css, png, html 등 mvc와 연관되지 않는 파일)

// 3) src/main/webapp
// View와 관련된 파일들

// - 예외처리
// 컨트롤러 implements ErrorController
// @RequestMapping("/error")
// 오류 내용 조회, 오류 코드 검사
// 404 -> WEB-INF/views/errors/404.jsp
// '[오류 파일]을 처리할 메소드나 뷰가 없습니다.' 브라우저에 출력
// 405 -> WEB-INF/views/errors/405.jsp
// 오류 메시지 그대로 전달
// 400 -> WEB-INF/views/errors/400.jsp
// 파라미터 정보 전달
// 500 -> WEB-INF/views/errors/500.jsp
// 예외 정보를 그대로 전달
