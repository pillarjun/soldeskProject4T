package com.team.dec051;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("cp", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String home2(HttpServletRequest req) {
		return home(req);
	}
	

}

