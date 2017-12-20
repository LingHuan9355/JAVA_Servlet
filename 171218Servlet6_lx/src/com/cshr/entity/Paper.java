package com.cshr.entity;

public class Paper {

	private int id;
	private String content;
	private String answer;
	
	public Paper() {}
	
	public Paper(int id, String content, String answer) {
		this.id = id;
		this.content = content;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}
