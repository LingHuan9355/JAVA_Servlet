package com.cshr.user.entity;

public class Users {

	//用户ID
	private int id;
	//用户名
	private String userName;
	//用户密码
	private String userPwd;
	
	//无参构造函数
	public Users() {}

	//有参构造函数
	public Users(int id, String userName, String userPwd) {
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
	}
	
     
	public Users(String userName, String userPwd) {
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", userPwd="
				+ userPwd + "]";
	}
	
	
	
}
