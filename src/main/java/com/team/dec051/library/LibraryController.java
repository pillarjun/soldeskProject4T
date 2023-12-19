package com.team.dec051.library;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibraryController {

	@RequestMapping(value = "/libraryfirst.go", method = RequestMethod.GET)
	public String goFirstLibrary(HttpServletRequest req) {
		req.setAttribute("cp", "library/first.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/librarysecond.go", method = RequestMethod.POST)
	public String goSecondLibrary(Library l, HttpServletRequest req) {
		req.setAttribute("readLibrary", l);
		req.setAttribute("cp", "library/second.jsp");
		return "index";
	}
	
}
