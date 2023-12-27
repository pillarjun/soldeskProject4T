package com.team.dec051.timeline;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.team.dec051.member.Member;;




public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionDestroyed");
		String dir = Constants.getPersonalFolderDir();
		HttpSession hs = se.getSession();
		try {
			if(hs.getAttribute("loginMember")!=null) {
				Member mb = (Member) hs.getAttribute("loginMember");
				System.out.println("folderName : "+mb.getM_folder());
				Path path = Paths.get(dir+"/"+mb.getM_folder()+"/"+hs.getAttribute("UploadedFileName"));
				
					Files.delete(path);
				
				System.out.println("파일삭제됨");
			}else {
				System.out.println("로그인 하지 않은 세션");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
