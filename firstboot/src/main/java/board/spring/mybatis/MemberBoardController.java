package board.spring.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberBoardController {
	@Autowired
	@Qualifier("memberServiceImpl")
	MemberService service;
	
	@GetMapping("/boardlogin")
	public String loginform() {
		return "board/loginform";
	}
	
	@PostMapping("/boardlogin")
	public String loginprocess(String id, int pw, HttpSession session) {
		MemberDTO dto = service.oneMember(id);
		
		if (dto != null) { // c_member에 아이디가 존재하고
			if (dto.getPw() == pw) { // 암호가 맞으면
				session.setAttribute("sessionid", id);
			}
		}
		return "board/start";
	}
	
	@RequestMapping("/boardlogout")
	public String logout(HttpSession session) {
		if (session.getAttribute("sessionid") != null)
			session.removeAttribute("sessionid");		
		return "board/start";
	}
}
