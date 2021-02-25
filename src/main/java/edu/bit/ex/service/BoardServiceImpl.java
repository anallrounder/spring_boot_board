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
	
	@Override
	public List<BoardVO> getlist() {
		log.info("service---list()----");
		return boardMapper.getlist() ;
	}

	@Override
	public List<BoardVO> getlist(Criteria cri) {
		log.info("service---list()-cri" + cri);
		return boardMapper.getlistWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		Log.info("service - getTotal ------");
		return boardMapper.getTotalCount(cri);
	}

	

}
