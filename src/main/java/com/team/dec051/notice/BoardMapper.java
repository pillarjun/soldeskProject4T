package com.team.dec051.notice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardMapper {

	public abstract int countBoard();
	public abstract List<Board> getAllBoard(PagingVO vo);
	public abstract int insertBoard(Board b);
	public abstract Board getOneBoard(int nb_no);
	public abstract int deleteBoard(int nb_no);
	public abstract int updateBoard(Board b);
	public abstract List<Board> getXmlBoard();
	
	public abstract int countSearchBoard(@Param("searchType") String searchType, @Param("keyword") String keyword);
	public abstract List<Board> searchBoard(PagingVO vo);
	public abstract int updateViewCnt(int nb_no);
	public abstract int updateReplyCnt(int nb_no);
	
	
	
	
}