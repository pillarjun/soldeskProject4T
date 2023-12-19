package com.team.dec051.timeline;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.team.dec051.member.Member;




public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		String dir = Constants.getPersonalFolderDir();
		HttpSession hs = se.getSession();
		
		if(hs.getAttribute("loginMember")==null) {
			System.out.println("로그인 되지 않은 상태의 세션 아웃");
		}else {
			Member mb = (Member) hs.getAttribute("loginMember");
			System.out.println(dir+"/"+mb.getM_folder()+"/"+hs.getAttribute("UploadedFileName"));
			try {
				Path path = Paths.get(dir+"/"+mb.getM_folder()+"/"+hs.getAttribute("UploadedFileName"));
				Files.delete(path);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

}
