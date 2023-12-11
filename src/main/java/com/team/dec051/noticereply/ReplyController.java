package com.team.dec051.noticereply;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.dec051.notice.BoardDAO;

@Controller
public class ReplyController {

	@Autowired
	private BoardDAO bDAO;
	@Autowired
	private ReplyDAO rDAO;
	
	// 댓글 등록 후 oneview 로 이동 
	@RequestMapping(value = "/reply.insert", method = RequestMethod.GET)
	public String insertReply(Reply r, HttpServletRequest req) {
		rDAO.insertReply(r, req);
		bDAO.updateReplyCnt(r.getNb_no(), req);
		return "redirect:/oneview.replygo?nb_no=" + r.getNb_no();
	}
	
	// 댓글 삭제 후 oneview 로 이동
	@RequestMapping(value = "/reply.delete", method = RequestMethod.GET)
	public String deleteReply(String nb_no, String r_no, HttpServletRequest req) {
		int inb_no = Integer.parseInt(nb_no);
		int ir_no = Integer.parseInt(r_no);
		rDAO.deleteReply(ir_no, req);
		bDAO.updateReplyCnt(inb_no, req);
	    return "redirect:/oneview.replygo?nb_no=" + inb_no;
	}
	
}
