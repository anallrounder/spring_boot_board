package edu.bit.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.BoardMapper;
import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;
import jdk.internal.org.jline.utils.Log;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//리스트
	@Override
	public List<BoardVO> getlist() {
		log.info("service---list()----");
		return boardMapper.getlist() ;
	}
	
	//페이징 리스트
	@Override
	public List<BoardVO> getlist(Criteria cri) {
		log.info("service---list()-cri" + cri);
		return boardMapper.getlistWithPaging(cri);
	}
	
	//게시글 수
	@Override
	public int getTotal(Criteria cri) {
		log.info("service---getTotal ------");
		return boardMapper.getTotalCount(cri);
	}
	
	//write_board
	@Override
	public BoardVO getBoard(int bid) {
		log.info("service---getBoard ------");
		
		return boardMapper.read(bid);
	}
	
	//조회수
	@Override
	public void uphit(BoardVO boardVO) {
		log.info("service---uphit----------");
		boardMapper.hitUpdate(boardVO);
	}

	// 글 입력
	@Override
	public void writeBoard(BoardVO boardVO) {
		log.info("service---writeBoard() ------");
		boardMapper.insert(boardVO);	
	}
	
	//글 수정
	@Override
	public void modifyBoard(BoardVO boardVO) {
		log.info("service---modifyBoard() ------");
		boardMapper.modify(boardVO);	
	}
	
	//글 삭제
	@Override
	public void deleteBoard(int bid) {
		log.info("service---deleteBoard() ------");
		boardMapper.delete(bid);
	}
	
	//댓글 작성 view
	@Override
	public BoardVO getReplyBoard(int bid) {
		log.info("service---getReplyBoard() ------");
		return boardMapper.readReplyBoard(bid);
	}
	
	// 댓글 입력 
	@Override
	public void replyBoard(BoardVO boardVO) {
		log.info("service---replyBoard() ------");
		boardMapper.updateShape(boardVO);
		boardMapper.insertReply(boardVO);
	}

}
