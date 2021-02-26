package edu.bit.ex.service;

import java.util.List;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

public interface BoardService {

	public List<BoardVO> getlist(); //list

	public List<BoardVO> getlist(Criteria cri); //페이징 list
	public int getTotal(Criteria cri); //글 갯수  count

	public BoardVO getBoard(int bid); //콘텐트뷰
	public void uphit(BoardVO boardVO); //조회수
	
	public void writeBoard(BoardVO boardVO); //글작성
	public void modifyBoard(BoardVO boardVO); //글수정
	
	public void deleteBoard(int bid);//글삭제

	public BoardVO getReplyBoard(int bid); //댓글뷰
	public void replyBoard(BoardVO boardVO);//댓글작성

	
}
