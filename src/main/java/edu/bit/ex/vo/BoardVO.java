package edu.bit.ex.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//bid      not null number(4)     
//bname             varchar2(20)  
//btitle            varchar2(100) 
//bcontent          varchar2(300) 
//bdate             date          
//bhit              number(4)     
//bgroup            number(4)     
//bstep             number(4)     
//bindent           number(4)  


@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class BoardVO {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	
	public BoardVO() {

	}
	
	public BoardVO(int bid, String bname, String btitle, String bcontent, Date bdate, int bhit, int bgroup, int bstep,
			int bindent) {
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
	}
	
}
