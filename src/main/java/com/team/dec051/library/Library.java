package com.team.dec051.library;

public class Library {
	private String libraryContent;
	private String libraryNotice;
	private String libraryBgm;
	private String libraryPhoto;
	private String libraryChannel;
	
	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Library(String libraryContent, String libraryNotice, String libraryBgm, String libraryPhoto,
			String libraryChannel) {
		super();
		this.libraryContent = libraryContent;
		this.libraryNotice = libraryNotice;
		this.libraryBgm = libraryBgm;
		this.libraryPhoto = libraryPhoto;
		this.libraryChannel = libraryChannel;
	}
	public String getLibraryContent() {
		return libraryContent;
	}
	public void setLibraryContent(String libraryContent) {
		this.libraryContent = libraryContent;
	}
	public String getLibraryNotice() {
		return libraryNotice;
	}
	public void setLibraryNotice(String libraryNotice) {
		this.libraryNotice = libraryNotice;
	}
	public String getLibraryBgm() {
		return libraryBgm;
	}
	public void setLibraryBgm(String libraryBgm) {
		this.libraryBgm = libraryBgm;
	}
	public String getLibraryPhoto() {
		return libraryPhoto;
	}
	public void setLibraryPhoto(String libraryPhoto) {
		this.libraryPhoto = libraryPhoto;
	}
	public String getLibraryChannel() {
		return libraryChannel;
	}
	public void setLibraryChannel(String libraryChannel) {
		this.libraryChannel = libraryChannel;
	}
	
}
