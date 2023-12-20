package com.team.dec051.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.team.dec051.timeline.Constants;


@Service
public class MemberDAO {
	
    private String uploadDir = Constants.getPersonalFolderDir();


	@Autowired
	private SqlSession ss;
	
	public void signup(Member m, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			m.setM_id(mr.getParameter("m_id"));
			m.setM_pw(mr.getParameter("m_pw"));
			m.setM_name(mr.getParameter("m_name"));
			m.setM_email(mr.getParameter("m_email"));
			m.setM_folder(mr.getParameter("m_id"));

			
			
			String m_photo = mr.getFilesystemName("m_photo");
			String m_photo_kor = URLEncoder.encode(m_photo, "UTF-8").replace("+", " ");
			m.setM_photo(m_photo_kor);

			if (ss.getMapper(MemberMapper.class).signupMember(m) == 1) {
				String folder_path = uploadDir+"/" + m.getM_folder();
				Path p = Paths.get(folder_path);
				
				Files.createDirectories(p);
				System.out.println("개인폴더생성");
				
				req.setAttribute("r", "가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "가입 실패");
		}
		
	}
	
	
	public Members memberIdCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberById(m));
	}
	
	public void login(Member m, HttpServletRequest req) {
		try {
			List<Member> members = ss.getMapper(MemberMapper.class).getMemberById(m);
			if (members.size() != 0) {
				Member dbM = members.get(0);
				
				if (dbM.getM_pw().equals(m.getM_pw())) {
					req.setAttribute("r", "로그인 성공");
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(600);
					
				} else {
					req.setAttribute("r", "로그인 실패(PW 오류");
				}
			} else {
				req.setAttribute("r", "로그인 실패(ID 없음)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인 실패(DB서버)");
		}
	}
	
	public void logout(HttpServletRequest req) {
		try {
			req.getSession().setAttribute("loginMember", null);
			req.setAttribute("r", "로그아웃 성공");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그아웃 실패");
		}
	}
	
	public void delete(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).deleteMember(m) == 1) {
				req.setAttribute("r", "탈퇴 성공");
				req.getSession().setAttribute("loginMember", null);
				
				String m_photo = m.getM_photo();
				m_photo = URLDecoder.decode(m_photo, "UTF-8");
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				File f = new File(path + "/" + m_photo);
				f.delete();
			} else {
				req.setAttribute("r", "이미 탈퇴처리 됨");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴 실패(DB서버)");
		}
	}
	
	public void update(HttpServletRequest req) {
		String path = null;
		Member m = (Member) req.getSession().getAttribute("loginMember");
		MultipartRequest mr = null;
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		try {
			path = req.getSession().getServletContext().getRealPath("resources/img");
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			
			new_m_photo = mr.getFilesystemName("m_photo");
			if (new_m_photo != null) {
				new_m_photo = URLEncoder.encode(new_m_photo, "UTF-8").replace("+", " ");
			} else {
				new_m_photo = old_m_photo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		try {
			m.setM_pw(mr.getParameter("m_pw"));
			m.setM_name(mr.getParameter("m_name"));
			m.setM_email(mr.getParameter("m_email"));
			m.setM_photo(new_m_photo);
			
			if (ss.getMapper(MemberMapper.class).updateMember(m) == 1) {
				req.setAttribute("r", "정보 수정 성공");
				if (!new_m_photo.equals(old_m_photo)) {
					new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
				}
				req.getSession().setAttribute("loginMember", m);
			} else {
				req.setAttribute("r", "정보 수정 실패");
				if (!new_m_photo.equals(old_m_photo)) {
					new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "정보 수정 실패");
			if (!new_m_photo.equals(old_m_photo)) {
				try {
					new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
}















