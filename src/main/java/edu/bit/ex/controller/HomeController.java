package edu.bit.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.vo.BoardVO;

//@RestController
//public class HomeController {
//
//	@RequestMapping("/")
//	@ResponseBody 
//	public String home() {
//		return "<h1>Hello, Spring Boot!<h1>";
//	}
//}

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		BoardVO board = new BoardVO();
		board.setBcontent("컨텐트");
		board.setBtitle("타이틀");
		board.setBname("홍길동");
		
		model.addAttribute("board", board);
		return "thymeleaf/index"; //타임리프로 넘기기 위해서 이렇게 작성함
	}
	
//	@GetMapping("/board")
//	public String board() {
//		return "list";
//	}

}
