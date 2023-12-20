package com.team.dec051.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardDAO {

	@Autowired
	private SqlSession ss;
	
	// 게시물 총 갯수를 연산하는 메소드
	public int countBoard() {
		return ss.getMapper(BoardMapper.class).countBoard();
	}
	
	//	리스트 보기를 위한 select 메서드
	public List<Board> getAllBoard(PagingVO vo,  HttpServletRequest req) {
		req.setAttribute("viewAll", ss.getMapper(BoardMapper.class).getAllBoard(vo));
		req.setAttribute("paging", vo);
		return  ss.getMapper(BoardMapper.class).getAllBoard(vo);
	}
	
	//  글 작성을 위한 insert 메서드
	public void insertBoard(Board b, HttpServletRequest req) {
		try {
			BoardMapper bm = ss.getMapper(BoardMapper.class);
			if(bm.insertBoard(b)==1) {
				req.setAttribute("r", "등록 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "등록 실패");
		}
	}
	
	// 게시물 하나를 보기 위한 select 메서드
	public  void getOneBoard(int nb_no, HttpServletRequest req) {
		try {
			req.setAttribute("oneboard", ss.getMapper(BoardMapper.class).getOneBoard(nb_no));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	// 게시물을 지우기 위한 delete 메서드
	public  void deleteBoard(int nb_no, HttpServletRequest req) {
		req.setAttribute("oneboard", ss.getMapper(BoardMapper.class).deleteBoard(nb_no));
	}	
	
	// 게시물을 수정하기 위한 update 메서드
	public void updateBoard(Board b, HttpServletRequest req) {
		req.setAttribute("oneboard", ss.getMapper(BoardMapper.class).updateBoard(b));
	}
	
	// 필터링 된 게시물 합계 연산하는 메소드
	public int countSearchBoard(String searchType, String keyword) {
		return ss.getMapper(BoardMapper.class).countSearchBoard(searchType, keyword);
	}
	
	//	필터링 된 리스트 보기를 위한 select 메서드
	public List<Board> searchBoard(PagingVO vo, HttpServletRequest req) {
		req.setAttribute("viewSearch", ss.getMapper(BoardMapper.class).searchBoard(vo));
		req.setAttribute("pagingSearch", vo);
		req.setAttribute("s_searchType", vo.getSearchType());
		req.setAttribute("s_keyword", vo.getKeyword());
		req.setAttribute("s_tatal", vo.getTotal());
		return  ss.getMapper(BoardMapper.class).searchBoard(vo);
	}
	
	// 조회수 증가를 위한 update 메서드
	public void updateViewCnt(int nb_no, HttpServletRequest req) { 
		ss.getMapper(BoardMapper.class).updateViewCnt(nb_no);
	}
	
	// 댓글 갯수 연산을 위한 update 메서드
	public void updateReplyCnt(int nb_no, HttpServletRequest req) { 
		ss.getMapper(BoardMapper.class).updateReplyCnt(nb_no);
	}

	
	
	
}
