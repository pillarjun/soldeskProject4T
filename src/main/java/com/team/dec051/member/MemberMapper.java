package com.team.dec051.member;

import java.util.List;

public interface MemberMapper {

	public abstract int signupMember(Member m);
	public abstract List<Member> getMemberById(Member m);
	public abstract int deleteMember(Member m);
	public abstract int updateMember(Member m);
}
