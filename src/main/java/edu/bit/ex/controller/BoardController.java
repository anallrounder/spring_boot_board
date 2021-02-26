package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.page.pageVO;
import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
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
	
	@RequestMapping("/write_view")
	public String write_view(Model model) throws Exception {
		log.debug("controller -- write_view -- 호출");
		return "write_view";
	}
	
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) throws Exception {
		log.info("controller -- content_view -- 호출");
		boardService.uphit(boardVO);
		model.addAttribute("content_view", boardService.getBoard(boardVO.getBid()));
		return "content_view";
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO, Model model) throws Exception {
		log.info("controller -- write -- 호출");
		boardService.writeBoard(boardVO);
		return "redirect:plist";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, Model model) throws Exception {
		log.info("controller -- modify -- 호출");
		boardService.modifyBoard(boardVO);
		return "redirect:plist";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO, Model model) throws Exception {
		log.info("controller -- delete -- 호출");
		boardService.deleteBoard(boardVO.getBid());
		return "redirect:plist";
	}
	
	@GetMapping("/reply_view")
	public String reply_view(BoardVO boardVO, Model model) throws Exception {
		log.info("controller -- reply_view -- 호출");
		model.addAttribute("reply_view", boardService.getReplyBoard(boardVO.getBid()));
		return "reply_view";
	}

	@PostMapping("/reply")
	public String reply(BoardVO boardVO, Model model) throws Exception {
		log.info("controller -- reply -- 호출");
		boardService.replyBoard(boardVO);
		return "redirect:plist";
	}

}
