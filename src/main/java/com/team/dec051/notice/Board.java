package com.team.dec051.notice;

public class Board {
	private int nb_no;
	private String nb_id;
	private String nb_pw;
	private String nb_title;
	private String nb_content;
	private String nb_when;
	private int nb_count;
	private int nb_replycount;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Board(int nb_no, String nb_id, String nb_pw, String nb_title, String nb_content, String nb_when, int nb_count,
			int nb_replycount) {
		super();
		this.nb_no = nb_no;
		this.nb_id = nb_id;
		this.nb_pw = nb_pw;
		this.nb_title = nb_title;
		this.nb_content = nb_content;
		this.nb_when = nb_when;
		this.nb_count = nb_count;
		this.nb_replycount = nb_replycount;
	}
		
	public int getNb_no() {
		return nb_no;
	}

	public void setNb_no(int nb_no) {
		this.nb_no = nb_no;
	}

	public String getNb_id() {
		return nb_id;
	}

	public void setNb_id(String nb_id) {
		this.nb_id = nb_id;
	}

	public String getNb_pw() {
		return nb_pw;
	}

	public void setNb_pw(String nb_pw) {
		this.nb_pw = nb_pw;
	}

	public String getNb_title() {
		return nb_title;
	}

	public void setNb_title(String nb_title) {
		this.nb_title = nb_title;
	}

	public String getNb_content() {
		return nb_content;
	}

	public void setNb_content(String nb_content) {
		this.nb_content = nb_content;
	}

	public String getNb_when() {
		return nb_when;
	}

	public void setNb_when(String nb_when) {
		this.nb_when = nb_when;
	}

	public int getNb_count() {
		return nb_count;
	}

	public void setNb_count(int nb_count) {
		this.nb_count = nb_count;
	}

	public int getNb_replycount() {
		return nb_replycount;
	}

	public void setNb_replycount(int nb_replycount) {
		this.nb_replycount = nb_replycount;
	}

////////////////////////////////////////////////////

	private PagingVO pagingvo;

	public PagingVO getPagingvo() {
		return pagingvo;
	}
	public void setPagingvo(PagingVO pagingvo) {
		this.pagingvo = pagingvo;
	}


}
