package com.team.dec051.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.dec051.noticereply.Reply;
import com.team.dec051.noticereply.ReplyDAO;

@Controller
public class NoticeController {

	@Autowired
	private BoardDAO bDAO;
	@Autowired
	private ReplyDAO rDAO;
	
	@RequestMapping(value = "/noticeBoard.go", method = RequestMethod.GET)
	public String goNoticeBoard() {
		return "redirect:/listBoard";
	}
	
	// 페이징에 걸러진 리스트 항목
	@RequestMapping(value = "/listBoard", method = RequestMethod.GET)
	public String home(PagingVO vo
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage
			, HttpServletRequest req) {
		int total = bDAO.countBoard();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		bDAO.getAllBoard(vo, req);
		req.setAttribute("cp", "notice/board.jsp");
		return "index";
	}
	
	// board 에서 insertview 로 이동
	@RequestMapping(value = "/insertview.go", method = RequestMethod.GET)
	public String insertview(HttpServletRequest req) {
		req.setAttribute("cp", "notice/insertview.jsp");
		return "index";
	}
	
	// insertview 에서 db에 데이터 저장 후 board으로 이동
	@RequestMapping(value = "/board.insert", method = RequestMethod.POST)
	public String insertBoard(Board b, HttpServletRequest req) {
		bDAO.insertBoard(b, req);
		return "redirect:/listBoard";
	}
	
	// board 에서 title을 클릭 후, 해당 oneview 로 이동
	@RequestMapping(value = "/oneview.go", method = RequestMethod.GET)
	public String getOneBoard(String nb_no, HttpServletRequest req) {
		int inb_no = Integer.parseInt(nb_no);
		bDAO.getOneBoard(inb_no, req);
		rDAO.getAllReply(inb_no, req);
		bDAO.updateViewCnt(inb_no, req);
		req.setAttribute("cp", "notice/oneview.jsp");
        return "index";
    }
	
	// oneview에서 댓글 입력 후 조회수 오르지 않게 하기 위한 우회로
	@RequestMapping(value = "/oneview.replygo", method = RequestMethod.GET)
	public String getOneBoardByReply(String nb_no, HttpServletRequest req) {
		int inb_no = Integer.parseInt(nb_no);
		bDAO.getOneBoard(inb_no, req);
		rDAO.getAllReply(inb_no, req);
		req.setAttribute("cp", "notice/oneview.jsp");
        return "index";
    }

	// oneview 에서 게시물 삭제 후 board 로 이동
	@RequestMapping(value = "/board.delete", method = RequestMethod.POST)
	public String deleteBoard(String nb_no, HttpServletRequest req) {
		int inb_no = Integer.parseInt(nb_no);
		bDAO.deleteBoard(inb_no, req);
		rDAO.deleteReplyBonus(inb_no, req);
	    return "redirect:/listBoard";
	}
	
	// oneview에서 updateview로 이동
	@RequestMapping(value = "/board.update.go", method = RequestMethod.POST)
	public String goUpdateViewPwCheck(String nb_no, HttpServletRequest req) {
		int inb_no = Integer.parseInt(nb_no);
		bDAO.getOneBoard(inb_no, req);
		req.setAttribute("cp", "notice/updateview.jsp");
		return "index";
	}
	
	// updateview 에서 게시물 수정 후 board 로 이동
	@RequestMapping(value = "/board.update", method = RequestMethod.POST)
	public String updateBoard(Board b, HttpServletRequest req) {
		b.getNb_no();
		bDAO.updateBoard(b, req);
	    return "redirect:/listBoard";
	}
	
	// 검색
	@RequestMapping(value = "/board.search", method = RequestMethod.GET)
	public String searchBoard(PagingVO vo
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage
			, @RequestParam(value="searchType", required=false)String searchType
			, @RequestParam(value="keyword", required=false)String keyword
			, HttpServletRequest req) {
		int total = bDAO.countSearchBoard(searchType, keyword);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		vo.setSearchType(searchType);
		vo.setKeyword(keyword);
		bDAO.searchBoard(vo, req);
		req.setAttribute("cp", "notice/searchview.jsp");
		return "index";
	}
	
}
