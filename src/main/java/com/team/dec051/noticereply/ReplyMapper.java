package com.team.dec051.noticereply;

import java.util.List;


public interface ReplyMapper {
	
	public abstract int countReply(int nb_no);
	public abstract List<Reply> getAllReply(int nb_no);
	public abstract int insertReply(Reply r);
	public abstract int deleteReply(int r_no);
	public abstract int deleteReplyBonus(int nb_no);
	
	
}
