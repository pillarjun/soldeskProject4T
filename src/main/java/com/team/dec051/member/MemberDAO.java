package com.team.dec051.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	private JavaMailSender mailSender;
	private int authNumber; 
	
	public void makeRandomNumber() {
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
	}
	
	//이메일 양식
	public String joinEmail(String m_email) {
		makeRandomNumber();
		String setFrom = "pillarjun416@gmail.com"; // email-config에 설정한 자신의 이메일 주소를 입력 
		String toMail = m_email;
		String title = "회원 가입 인증 이메일 입니다."; 
		String content = 
				"### 사이트 발송" + 
		        "<br>" + 
				"인증 번호는 " + authNumber + "입니다." + 
				"<br>" + 
				"해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		mailSend(setFrom, toMail, title, content);
		return Integer.toString(authNumber);
	}
			
	//이메일 전송 메소드
	public void mailSend(String setFrom, String toMail, String title, String content) {
		MimeMessage message = mailSender.createMimeMessage();
		System.out.println("이메일 전송 메소드 2 !!");
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content,true);
			mailSender.send(message);
			System.out.println("이메일 전송 메소드 Try!!");
		} catch (MessagingException e) {;
			e.printStackTrace();
			System.out.println("이메일 전송 메소드 catch!!");
		}
	}
	
	public void signup(Member m, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
			m.setM_id(mr.getParameter("m_id"));
			m.setM_pw(mr.getParameter("m_pw"));
			m.setM_name(mr.getParameter("m_name"));
			m.setM_email(mr.getParameter("m_email"));

			String m_photo = mr.getFilesystemName("m_photo");
			String m_photo_kor = URLEncoder.encode(m_photo, "UTF-8").replace("+", " ");
			m.setM_photo(m_photo_kor);

			if (ss.getMapper(MemberMapper.class).signupMember(m) == 1) {
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
				// System.out.println(dbM.getm_id());
				
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















