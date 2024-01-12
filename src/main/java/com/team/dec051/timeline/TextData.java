package com.team.dec051.timeline;

import java.util.ArrayList;


public class TextData {

	private String transcript;
	private ArrayList<String> TopWords;
	private ArrayList<WordAndTime> wat;
	
	public TextData() {
	}

	

	public TextData(String transcript, ArrayList<String> topWords, ArrayList<WordAndTime> wat) {
		super();
		this.transcript = transcript;
		TopWords = topWords;
		this.wat = wat;
	}



	public String getTranscript() {
		return transcript;
	}

	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}

	public ArrayList<String> getTopWords() {
		return TopWords;
	}

	public void setTopWords(ArrayList<String> topWords) {
		TopWords = topWords;
	}

	public ArrayList<WordAndTime> getWat() {
		return wat;
	}

	public void setWat(ArrayList<WordAndTime> wat) {
		this.wat = wat;
	}

	

	

	

	


	

}
