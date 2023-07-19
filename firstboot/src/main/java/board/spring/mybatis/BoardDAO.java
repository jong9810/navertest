package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// 순서 상관 있음(@Configuration -> @ComponentScan)
@Mapper // 순서 상관 없음
@Repository
public interface BoardDAO {
	 int insertBoard(BoardDTO dto);
	
	 int getTotalBoard();
	
	 List<BoardDTO> boardList(int[] limit);
	
	 int updateViewcount(int seq);
	
	 BoardDTO selectDetail(int seq);
	
	 int deleteBoard(int seq);
	
	 int updateBoard(BoardDTO dto);
	
	 List<BoardDTO> searchList(HashMap<String, String> map);
	 
	 int getSearchBoard(HashMap<String, String> map);
	 
	 BoardMemberDTO boardWriterInform(int seq);
}

// - spring boot + mybatis
// 1) spring mvc(sts3)
// web.xml(서버 환경설정)
// servlet-context.xml(spring mvc 설정)
// spring-mybatis.xml(mybatis 연동 설정)
// mybatis-config.xml(mybatis 설정)
// sql-mapping.xml(여러 개 가능)
// DAO : SqlSession 객체 생성해서 이용(spring-mybatis.xml)

// 2) spring boot(sts4)
// 경로 : src/main/resources/
// application.properties에 db 연결 정보를 설정해준다.
// 	 jdbc driver, url, account, password 지정
// 	 sql 매핑 xml 파일의 위치를 지정
// spring-mybatis.xml(mybatis 연동 설정)
// mybatis-config.xml(mybatis 설정)
// sql-mapping.xml(여러 개 가능)
// 컨트롤러, 서비스, 뷰, DTO를 구현하는 방법은 spring mvc와 동일하다.

// # DAO : 스프링 부트가 자동으로 생성하는 SqlSession 이용(내장)
// DAO 인터페이스 위에 @Mapper, @Repository 어노테이션을 붙인다.
// DAO 인터페이스 또는 Mapper 인터페이스라고 부른다.
// DAO 메서드 : [리턴타입] [매핑sql아이디명]([매개변수]);
// DAO 메서드 위에 @Select("[sql문]")을 적으면 [sql문]과 연결된다.

// # sql-mapping.xml
// <mapper namespace="[패키지명.DAO인터페이스명]">
// 매핑 sql id와 DAO 인터페이스의 메소드명이 같은 것을 연결해준다.
// 따라서 메소드명과 sql id를 반드시 동일하게 해주어야 한다.

