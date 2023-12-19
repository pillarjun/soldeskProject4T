package com.team.dec051.timeline;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class STSController {
	
	
	@Autowired
	private STSDAO sdao;
	
	@Autowired
	private TokenManager tm;
	
	
	@RequestMapping(value="/timeline.go", method=RequestMethod.GET)
	public String goToTimeline() {
		return "VideoToText";
	}
	
	
	@RequestMapping(value="/sendToPython", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody TextData sendToPython(HttpServletRequest req) {
		System.out.println("sendToPython");
		TextData td = null;
		if(tm.checkToken(req)) {
			td= sdao.send_video(req);
		}else {
			System.out.println("새로고침으로 인한 요청");
		}
		
		return td;
	}
	
	
	@RequestMapping(value="/endSession", method = RequestMethod.GET)
	public String endSession(HttpServletRequest req) {
		req.getSession().invalidate();
		return "VideoToText";
	}
	



}
