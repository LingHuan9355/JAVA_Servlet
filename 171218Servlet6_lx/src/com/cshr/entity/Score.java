package com.cshr.entity;

public class Score {

	
	private int id;
	private String username;
	private int score;
	
	public Score() {}
	
	public Score(String username) {
		this.username = username;
	}

	public Score(String username, int score) {
		this.username = username;
		this.score = score;
	}

	public Score(int id, String username, int score) {
		this.id = id;
		this.username = username;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
