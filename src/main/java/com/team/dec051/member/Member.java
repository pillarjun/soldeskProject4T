package com.team.dec051.member;

public class Member {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_email;
	private String m_photo;
	private String m_folder;
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(String m_id, String m_pw, String m_name, String m_email, String m_photo, String m_folder) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_photo = m_photo;
		this.m_folder = m_folder;
	}
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_photo() {
		return m_photo;
	}
	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}
	public String getM_folder() {
		return m_folder;
	}
	public void setM_folder(String m_folder) {
		this.m_folder = m_folder;
	}
	
}
