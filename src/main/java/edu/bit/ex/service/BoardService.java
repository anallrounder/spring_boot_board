package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getlist(); //list

	public List<BoardVO> getlist(Criteria cri); //페이징 list
	public int getTotal(Criteria cri); //글 갯수  count

	
	
}
