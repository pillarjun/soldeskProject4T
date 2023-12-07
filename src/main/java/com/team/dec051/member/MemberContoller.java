package com.team.dec051.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberContoller {

	@Autowired
	private MemberDAO mDAO;	
	@Autowired
	private MailSendService mailService;
	
	//이메일 인증
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET)
	@ResponseBody
	public String mailCheck(String email) {
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		return mailService.joinEmail(email);
	}
	
	@RequestMapping(value = "/member.login.go", method = RequestMethod.GET)
	public String goMemberLogin(HttpServletRequest req) {
		req.setAttribute("cp", "member/login.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.signup.go", method = RequestMethod.GET)
	public String goSignup(HttpServletRequest req) {
		req.setAttribute("cp", "member/signup.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.signup", method = RequestMethod.POST)
	public String signupMember(Member m, HttpServletRequest req) {
		mDAO.signup(m, req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public @ResponseBody Members memberIdCheck(Member m) {
		return mDAO.memberIdCheck(m);
	}
	
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String goMemberInfo(HttpServletRequest req) {
		req.setAttribute("cp", "member/info.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest req) {
		mDAO.logout(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.resign", method = RequestMethod.GET)
	public String memberResign(HttpServletRequest req) {
		mDAO.delete(req);
		req.setAttribute("cp", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String memberUpdate(HttpServletRequest req) {
		mDAO.update(req);
		req.setAttribute("cp", "member/info.jsp");
		return "index";
	}
	
	
	
	
	
}










