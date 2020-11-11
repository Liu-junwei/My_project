package com.itshixun.pojo;

public class User {//用户使用userid和password登录
	private String userid;//账号
	private String nickname;//用户昵称
	private String password;//用户密码
	private String role;//用户角色
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userid, String nickname, String password,String role) {
		super();
		this.userid = userid;
		this.nickname = nickname;
		this.password = password;
		this.role = role;
	}

	public User(String userid, String password,String role) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", nickname=" + nickname
				+ ", password=" + password + ", role=" + role + "]";
	}

}
