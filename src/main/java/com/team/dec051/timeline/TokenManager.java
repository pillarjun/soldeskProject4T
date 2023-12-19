package com.team.dec051.timeline;

import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class TokenManager {
	
	public String generateToken() {
		SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[32];
        secureRandom.nextBytes(token);
        String t = Base64.getUrlEncoder().withoutPadding().encodeToString(token);
        return t;
	}
	
	public boolean checkToken(HttpServletRequest req) {
		
		HttpSession hs = req.getSession(false);
		String newToken = (String) hs.getAttribute("newToken");
		String oldToken = (String) hs.getAttribute("oldToken");
		String token = req.getParameter("token");
		
		System.out.println("token : " + token);
		System.out.println("oldToken : "+ oldToken);
		System.out.println("newToken : "+ newToken);
		
		if(oldToken==null) {
			if(newToken==null) {
				
				System.out.println("새로운 요청");
				hs.setAttribute("oldToken", hs.getAttribute("newToken"));
				hs.setAttribute("newToken", generateToken());
				return true;
			}else {
				if(token.equals("")) {
					System.out.println("두번째요청-새로고침");
					return false;
				}else if(token.equals(newToken)){
					System.out.println("두번째 요청-새로고침이 아님");
					hs.setAttribute("oldToken", hs.getAttribute("newToken"));
					hs.setAttribute("newToken", generateToken());
					return true;
				}
			}
			
		}else {
			if(newToken==null) {
				System.out.println("이 경우는 있을 수 없음..");
				return false;
			}else {
				if(token.equals("")) {
					System.out.println("새로고침");
					return false;
				}else if(token.equals(oldToken)) {
					System.out.println("새로고침");
					return false;
				}else {
					System.out.println("또 다른 새로운 요청");
					hs.setAttribute("oldToken", hs.getAttribute("newToken"));
					hs.setAttribute("newToken", generateToken());
					return true;
				}
			}
		}
		
		return false;
	}
	
}
