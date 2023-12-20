package com.team.dec051.noticereply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReplyDAO {
	
	@Autowired
	private SqlSession ss;

	// 게시물에 달린 댓글의 갯수를 연산하는 메소드
	public int countReply(int nb_no, HttpServletRequest req) {
		req.setAttribute("countReply", ss.getMapper(ReplyMapper.class).countReply(nb_no));
		return ss.getMapper(ReplyMapper.class).countReply(nb_no);
	}
	
	//	리스트 보기를 위한 select 메서드
	public List<Reply> getAllReply(int nb_no, HttpServletRequest req){
			req.setAttribute("replyAll", ss.getMapper(ReplyMapper.class).getAllReply(nb_no));
			return ss.getMapper(ReplyMapper.class).getAllReply(nb_no);
	}
	
	//  댓글 작성을 위한 insert 메서드
	public void insertReply(Reply r, HttpServletRequest req) {
		try {
			ReplyMapper rm = ss.getMapper(ReplyMapper.class);
			if(rm.insertReply(r)==1) {
				req.setAttribute("rr", "등록 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("rr", "등록 실패");
		}
	}

	// 댓글을 지우기 위한 delete 메서드
	public void deleteReply(int r_no, HttpServletRequest req) {
		req.setAttribute("onereply", ss.getMapper(ReplyMapper.class).deleteReply(r_no));
	}
	
	// 게시물 삭제 시, 게시물에 달려있던 댓글까지 지우기 위한 delete 메서드
	public void deleteReplyBonus(int nb_no, HttpServletRequest req) {
		req.setAttribute("onereply", ss.getMapper(ReplyMapper.class).deleteReplyBonus(nb_no));
	}


	
	
}
