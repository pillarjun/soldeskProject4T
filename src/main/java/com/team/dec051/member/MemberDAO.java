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
import org.springframework.web.multipart.MultipartFile;

import com.team.dec051.timeline.Constants;


@Service
public class MemberDAO {
	
    private String uploadDir = Constants.getPersonalFolderDir();


	@Autowired
	private SqlSession ss;
	
	public List<Member> idcheck(String m_email, HttpServletRequest req) {
		req.setAttribute("getInfoId", ss.getMapper(MemberMapper.class).getId(m_email));
		return ss.getMapper(MemberMapper.class).getId(m_email);
	}
	
	public List<Member> pwcheck(String m_id, HttpServletRequest req) {
		req.setAttribute("getInfoPw", ss.getMapper(MemberMapper.class).getPw(m_id));
		return ss.getMapper(MemberMapper.class).getPw(m_id);
	}
	
	public void signup(MultipartFile file, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			System.out.println(path);
			
			Member m = new Member();
			
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(path, fileName).toString();
			file.transferTo(new File(filePath));
		
			m.setM_id(req.getParameter("m_id"));
			m.setM_pw(req.getParameter("m_pw"));
			m.setM_name(req.getParameter("m_name"));
			m.setM_email(req.getParameter("m_email"));
			m.setM_folder(req.getParameter("m_id"));
			m.setM_photo(fileName);
			
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
					req.getSession().setMaxInactiveInterval(6000);
					
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
	
	   public void update(MultipartFile file, HttpServletRequest req) {
		      String path = req.getSession().getServletContext().getRealPath("resources/img");
		      Member m = (Member) req.getSession().getAttribute("loginMember");
		      String old_m_photo = m.getM_photo();
		      String new_m_photo = file.getOriginalFilename();
		      
		      try {
		         if (new_m_photo.isEmpty()) {
		            new_m_photo = old_m_photo;
		         }
		         else{
		         String filePath = Paths.get(path, new_m_photo).toString();
		         file.transferTo(new File(filePath));
			 }
		      } catch (Exception e) {
		         e.printStackTrace();
		         return;
		      }
		      
		      try {
		         m.setM_pw(req.getParameter("m_pw"));
		         m.setM_name(req.getParameter("m_name"));
		         m.setM_email(req.getParameter("m_email"));
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

/*public void update(MultipartFile file, HttpServletRequest req) {
	String path = null;
	Member m = (Member) req.getSession().getAttribute("loginMember");
	String old_m_photo = m.getM_photo();
	try {
		path = req.getSession().getServletContext().getRealPath("resources/img");
		String originalNewFileName = file.getOriginalFilename();
		String old_pw = m.getM_pw();
		String new_m_photo = old_m_photo;
		String new_pw = old_pw;
		
		if(!file.isEmpty()) {
			String oldFileExtension = getFileExtension(originalNewFileName);
			new_m_photo = generateUniqueFileName(oldFileExtension);
			String newFilePath = Paths.get(path, new_m_photo).toString();
			file.transferTo(new File(newFilePath));
		}
		
		if(!req.getParameter("m_pw").isEmpty()) {
			new_pw = req.getParameter("m_pw");
		}

		m.setM_pw("new_pw");
		m.setM_name(req.getParameter("m_name"));
		m.setM_email(req.getParameter("m_email"));
		m.setM_photo(new_m_photo);
		
		if (ss.getMapper(MemberMapper.class).updateMember(m) == 1) {
			req.setAttribute("r", "정보 수정 성공");
			if (!new_m_photo.equals(old_m_photo)) {
				new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
			}
			req.getSession().setAttribute("loginMember", m);
		} else {
			req.setAttribute("r", "정보 수정 실패");
		}
	} catch (Exception e) {
		e.printStackTrace();
		req.setAttribute("r", "정보 수정 실패");
		}
	}*/
	
	
}















