package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import uploaddownload.MyPathConfig;

@SpringBootApplication 
@ComponentScan // 현재 패키지 스캔(스캔 패키지 추가되지 않았을 경우에는 쓰지 않아도 됨)
@ComponentScan(basePackageClasses=MyPathConfig.class)
@ComponentScan(basePackages="errors")
@ComponentScan(basePackages="board.spring.mybatis")
@MapperScan(basePackages="board.spring.mybatis")
public class FirstbootApplication {

	public static void main(String[] args) {
		// 서버 시작, @패키지 스캔(component-scan)을 포함하고 있다.
		SpringApplication.run(FirstbootApplication.class, args);
		System.out.println("서버 시작중");
	}

}

// 1. 스프링부트 메인 클래스(com.example.demo 패키지만 읽어옴)
// : 서버시작, 패키지 내부 컴포넌트 스캔

// 2. jsp파일 경로, 확장자, 서블릿 api, jstl api는 포함하고 있지 않다.
// (pom.xml 수동 추가 설정)

// 3. xml 최소화 / application.properties 파일에 설정을 한다.
// (application.properties 파일에 설정).

// 4. ajax : pom.xml 라이브러리 추가 X, jquery 라이브러리는 필요
// src/main/resources/static/js/jquery-3.6.4.min.js
// src/main/resources/static/images
// src/main/resources/static/css
// => http://localhost:8063/js/jquery...m

// 5-1.file upload : pom.xml 라이브러리 추가 X
// 5-2. servlet-context.xml 불필요
// <beans:bean id="multipartResolver"... />
// 5-3. javax.servlet 패키지명 -> jakarta.servlet 패키지명(import 새로)

// - 실제 서버 내부에 파일 저장 폴더를 url로 접근하여 브라우저에 출력하기
// c:kdt/upload/a.png 업로드했다면
// http://localhost:8063/upload/a.png 이미지 보여주고 싶다면
// <resources mapping="/upload/**" location="file:///c:/kdt/upload" />

// http://localhost:8063/매핑 url
// 404 : 파일(컨트롤러, 컨트롤러 메소드, 뷰 등)이 없을 경우
// 405 : post 방식 요청 -> get 방식 컨트롤러인 경우(역도 마찬가지)
// 400 : 요청 파라미터 타입, 컨트롤러 메소드 매개변수 타입 불일치
// 		 파일 업로드시 enctype/method/type 등 
// 400번대 에러는 클라이언트 실수, 500번대 에러는 서버 실수
// 500 : 자바 예외 발생
// 예외 발생시 자동으로 /error url로 이동한다.
// 따라서 예외처리를 하기 위해서는 /error로 매핑된 메소드를 만들면 된다.
// @Controller : 일반적인 컨트롤러
// @RestController : ajax만 사용하는 컨트롤러
// @Controller(ErrorController 상속) : 예외 전담 컨트롤러

// @ComponentScan(basePackages="uploaddownload")
// 어느 패키지의 @을 스캔할지 결정(xxxApplication 클래스에 정의하는 게 좋음)

// @ComponentScan
// @Service, @Repository, @Component, @Controller, @Configuration 스캔 가능
// @Mapper는 스캔 불가(@MapperScan으로 스캔 가능)

// - 로그 출력하기
// src/main/resource에 logback-spring.xml 파일 생성
// <configuration> 태그 안에 설정 내용 정의
// spring boot 로그 기본 사항
// <include resources="org/springframework/boot/logging/logback/base.xml" />
// 해당 패키지를 실행할 때 로그 기록
// <logger name="board.spring.mybatis" level="DEBUG" />