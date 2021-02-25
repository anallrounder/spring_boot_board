package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	@Select("select * from mvc_board order by bgroup desc, bstep asc")
	public List<BoardVO> getlist();

	@Select("select * from (select rownum as rnum, a.* from ( select * from mvc_board order by bGroup desc, bStep asc)a where rownum <= #{pageNum} * #{amount}) where rnum > (#{pageNum}-1) * #{amount}")
	public List<BoardVO> getlistWithPaging(Criteria cri);
	
	@Select("select count(*) from mvc_board")
	public int getTotalCount(Criteria cri);

}
