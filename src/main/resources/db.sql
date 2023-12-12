drop table site_member;
create table site_member(
	m_id varchar2(10 char) primary key,
	m_pw varchar2(10 char) not null,
	m_name varchar2(10 char) not null,
	m_email varchar2(80 char) not null,
	m_photo varchar2(200 char) not null
);

select * from site_member;
delete from site_member;

--------------------------------------------
drop table noticeboard;
create table noticeboard(
	nb_no number(5) primary key,
	nb_id varchar2(100) not null, 
	nb_pw varchar2(100) not null,
	nb_title varchar2(100) not null, 
	nb_content varchar2(4000) not null,
	nb_when varchar2(30) not null,
	nb_count number(5) not null,
	nb_noticereplycount number(5) not null
);

drop sequence noticeboard_seq;
create sequence noticeboard_seq;

select * from noticeboard order by nb_no desc 
delete from noticeboard;

---------------------------------------------------
drop table noticereplyboard;
create table noticereplyboard (
	nb_no number(4) not null,
	r_no number(4) primary key,
	r_id varchar2(100) not null, 
	r_pw varchar2(100) not null,
	r_content varchar2(4000) not null,
	r_when varchar2(30) not null
);
  			
drop sequence noticereplyboard_seq;
create sequence noticereplyboard_seq;

select * from noticereplyboard;
delete from noticereplyboard;

--------------------------------------
drop table cloudfile;
create table cloudfile (
	m_id varchar2(10 char) not null,
	c_no number(4) primary key,
	c_name varchar2(100) not null, 
	c_detail varchar2(4000),
	c_mpfile varchar2(100),
	c_when varchar2(30) not null
);
  			
drop sequence cloudfile_seq;
create sequence cloudfile_seq;

select * from cloudfile;
delete from cloudfile;