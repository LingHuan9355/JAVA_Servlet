package com.cshr.test.entity;

public class User {

	private String id;
	private String sex;
	private String name;
	private String brith;
	public User() {
		super();
	}
	
	
	
	public User(String id, String name, String brith) {
		super();
		this.id = id;
		this.name = name;
		this.brith = brith;
	}



	public User(String id, String sex, String name, String brith) {
		super();
		this.id = id;
		this.sex = sex;
		this.name = name;
		this.brith = brith;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrith() {
		return brith;
	}
	public void setBrith(String brith) {
		this.brith = brith;
	}
	
	
}
