package com.team.dec051.noticereply;

public class Reply {
//	create table replyboard (
//			nb_no number(4) not null,
//			r_no number(4) primary key,
//			r_id varchar2(100) not null, 
//			r_pw varchar2(100) not null,
//			r_content varchar2(4000) not null,
//			r_when varchar2(30) not null
//		);
	private int nb_no;
	private int r_no;
	private String r_id;
	private String r_pw;
	private String r_content;
	private String r_when;
	
	
	public int getNb_no() {
		return nb_no;
	}
	public void setNb_no(int nb_no) {
		this.nb_no = nb_no;
	}
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getR_pw() {
		return r_pw;
	}
	public void setR_pw(String r_pw) {
		this.r_pw = r_pw;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_when() {
		return r_when;
	}
	public void setR_when(String r_when) {
		this.r_when = r_when;
	}
	public Reply(int nb_no, int r_no, String r_id, String r_pw, String r_content, String r_when) {
		super();
		this.nb_no = nb_no;
		this.r_no = r_no;
		this.r_id = r_id;
		this.r_pw = r_pw;
		this.r_content = r_content;
		this.r_when = r_when;
	}
	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
