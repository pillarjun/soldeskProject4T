drop table site_member;
create table site_member(
	nb_id varchar2(10 char) primary key,
	nb_pw varchar2(10 char) not null,
	nb_name varchar2(10 char) not null,
	nb_email varchar2(80 char) not null,
	nb_photo varchar2(200 char) not null
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