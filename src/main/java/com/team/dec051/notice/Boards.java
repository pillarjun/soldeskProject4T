package com.team.dec051.notice;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Boards {
	private List<Board> board;

	public List<Board> getBoard() {
		return board;
	}

	public void setBoard(List<Board> board) {
		this.board = board;
	}

	public Boards(List<Board> board) {
		super();
		this.board = board;
	}

	public Boards() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
