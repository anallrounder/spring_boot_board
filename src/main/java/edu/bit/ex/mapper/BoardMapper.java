package edu.bit.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.bit.ex.page.Criteria;
import edu.bit.ex.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	//@Select("select * from mvc_board order by bgroup desc, bstep asc")
	public List<BoardVO> getlist(); //리스트

	//@Select("select * from (select rownum as rnum, a.* from ( select * from mvc_board order by bgroup desc, bstep asc)a where rownum <= #{pageNum} * #{amount}) where rnum > (#{pageNum}-1) * #{amount}")
	public List<BoardVO> getlistWithPaging(Criteria cri); //페이징 리스트
	
	//@Select("select count(*) from mvc_board")
	public int getTotalCount(Criteria cri); // 

	public BoardVO read(int bid); // 글작성페이지
	public void hitUpdate(BoardVO boardVO); // 조회수

	//@Insert("insert into mvc_board (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) values (mvc_board_seq.nextval, #{bname}, #{btitle}, #{bcontent}, 0, mvc_board_seq.currval, 0, 0)")
	public void insert(BoardVO boardVO); //입력
	public void modify(BoardVO boardVO); //수정

	public void delete(int bid); //삭제

	public BoardVO readReplyBoard(int bid); //댓글 뷰페이지
	public void reply(BoardVO boardVO); //댓글입력

	public void updateShape(BoardVO boardVO);//댓글 형태
	public void insertReply(BoardVO boardVO); //댓글 입력
}
