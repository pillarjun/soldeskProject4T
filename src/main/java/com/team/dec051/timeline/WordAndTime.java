package com.team.dec051.timeline;

public class WordAndTime {
	
	private int serialNo;
	private String word;
	private int second;
	
	
	public WordAndTime() {
	}


	public WordAndTime(int serialNo, String word, Integer second) {
		super();
		this.serialNo = serialNo;
		this.word = word;
		this.second = second;
	}


	public int getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}


	public String getWord() {
		return word;
	}


	public void setWord(String word) {
		this.word = word;
	}


	public int getSecond() {
		return second;
	}


	public void setSecond(int second) {
		this.second = second;
	}
	
	

}
