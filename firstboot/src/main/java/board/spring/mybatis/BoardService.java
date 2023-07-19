package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	int insertBoard(BoardDTO dto);
	
	int getTotalBoard();
	
	List<BoardDTO> boardList(int[] limit);
	
	BoardDTO updateViewcountAndSelectDetail(int seq);
	
	int deleteBoard(int seq);
	
	int updateBoard(BoardDTO dto);
	
	List<BoardDTO> searchList(HashMap<String, String> map);
	
	int getSearchBoard(HashMap<String, String> map);
	
	BoardMemberDTO boardWriterInform(int seq);
}
