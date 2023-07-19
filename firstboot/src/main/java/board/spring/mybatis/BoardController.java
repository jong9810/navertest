package board.spring.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardServiceImpl")
	BoardService service;
	
	@RequestMapping("/")
	public String start() {
		return "board/start";
	}
	
	@GetMapping("/boardwrite")
	public String writeform() {
		return "board/writeform";
	}
	
	@PostMapping("/boardwrite")
	public ModelAndView writeprocess(String title, String contents, String writer, int pw) {
		BoardDTO dto = new BoardDTO(title, contents, writer, pw);
		
		int insertcount = service.insertBoard(dto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("insertcount", insertcount);
		mv.setViewName("board/start");
		return mv;
	}
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value="page", required=false, defaultValue="1") int page) {
		int totalBoard = service.getTotalBoard();
		
		int limitCount = 4; // 페이지당 게시글 개수
		if (page < 1) page = 1;
		int limitIndex = (page - 1) * limitCount; // 페이지의 첫 게시글 index
		int[] limit = {limitIndex, limitCount};
		List<BoardDTO> list = service.boardList(limit);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalBoard", totalBoard);
		mv.addObject("limit", limit);
		mv.addObject("boardList", list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/boarddetail")
	public ModelAndView boarddetail(int seq) {
		ModelAndView mv = new ModelAndView();
		BoardDTO dto = service.updateViewcountAndSelectDetail(seq);
		mv.addObject("detaildto", dto);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping("/boarddelete")
	public String boarddelete(int seq) {
		service.deleteBoard(seq);
		return "redirect:/boardlist"; 
	}
	
	@RequestMapping("/boardupdate")
	public String boardupdate(BoardDTO dto) {
		service.updateBoard(dto);
		return "redirect:/boardlist";
	}
	
	@RequestMapping("/boardsearchlist")
	public ModelAndView boardsearchlist(
		@RequestParam(value="item", required=false, defaultValue="all") String item, 
		@RequestParam(value="word", required=false, defaultValue="") String word, 
		@RequestParam(value="page", required=false, defaultValue="1") int page) 
	{
		if (page < 1) page = 1;
		HashMap<String, String> map = new HashMap<>();
		if (item.equals("all")) item = null;
		map.put("colname", item);
		map.put("colvalue", word);
		//map.put("limitindex", ((page - 1) * 4));
		//map.put("limitcount", 4);
		List<BoardDTO> searchlist = service.searchList(map);
		int searchcount = service.getSearchBoard(map);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList", searchlist);
		mv.addObject("totalBoard", searchcount);
		mv.setViewName("board/searchlist");
		return mv;
	}
	
	@RequestMapping("/boardwriterinform")
	public ModelAndView boardwriterinform(int seq) {
		BoardMemberDTO writerdto = service.boardWriterInform(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("writerdto", writerdto);
		mv.setViewName("board/writerinform");
		return mv;
	}
}
