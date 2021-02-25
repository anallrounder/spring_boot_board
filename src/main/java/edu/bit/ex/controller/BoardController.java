package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.pageVO;
import edu.bit.ex.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j //Log4j보다 좋은것!이거 쓰자. 기본적으로 이거 제공함
@Controller
@RequestMapping("board/*")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//list
	@RequestMapping("/list")
	public String list(Model model) {
		log.debug("controller -- list -- 호출");
		log.info("controller -- list -- 호출");
		model.addAttribute("list", boardService.getlist());
		return "thymeleaf/list";
	}
	
	//page list
	@RequestMapping("/plist")
	public String list(Criteria cri, Model model) throws Exception {
		log.debug("controller -- list2 -- 호출" + cri);
		log.info("controller -- list2 -- 호출" + cri);
		
		model.addAttribute("list", boardService.getlist(cri));
		
		int total = boardService.getTotal(cri);
		model.addAttribute("pageMaker", new pageVO(cri, total));
		return "list";
	}
}
