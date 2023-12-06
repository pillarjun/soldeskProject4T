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

