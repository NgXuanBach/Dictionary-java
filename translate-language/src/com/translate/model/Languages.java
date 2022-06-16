package com.translate.model;

public class Languages {
	private String vietnamese;
	private String english;

	public Languages() {
	}

	public Languages(String vietnamese, String english) {
		super();
		this.vietnamese = vietnamese;
		this.english = english;
	}

	public String getVietnamese() {
		return vietnamese;
	}

	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}
}
