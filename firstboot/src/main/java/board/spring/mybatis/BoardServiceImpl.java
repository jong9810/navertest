package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // bean 객체명 : boardServiceImpl
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public int insertBoard(BoardDTO dto) {
		return dao.insertBoard(dto);
	}

	@Override
	public int getTotalBoard() {
		return dao.getTotalBoard();
	}

	@Override
	public List<BoardDTO> boardList(int[] limit) {
		return dao.boardList(limit);
	}

	@Override
	public BoardDTO updateViewcountAndSelectDetail(int seq) {
		dao.updateViewcount(seq);
		return dao.selectDetail(seq);
	}

	@Override
	public int deleteBoard(int seq) {
		return dao.deleteBoard(seq);
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		return dao.updateBoard(dto);
	}

	@Override
	public List<BoardDTO> searchList(HashMap<String, String> map) {
		return dao.searchList(map);
	}

	@Override
	public int getSearchBoard(HashMap<String, String> map) {
		return dao.getSearchBoard(map);
	}

	@Override
	public BoardMemberDTO boardWriterInform(int seq) {
		return dao.boardWriterInform(seq);
	}
	
	
}
