package com.cshr.user.entity;

public class Users {

	//�û�ID
	private int id;
	//�û���
	private String userName;
	//�û�����
	private String userPwd;
	
	//�޲ι��캯��
	public Users() {}

	//�вι��캯��
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
