package com.hanbit.member.domain;

public class MemberBean {
	private String userId, userPw, name, ssn, regdate;

	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setUserId(String id) {
		this.userId = id;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setUserPw(String pw) {
		this.userPw = pw;
	}
	public String getUserPw() {
		return userPw;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	public String getSSN() {
		return ssn;
	}

	public String toString() {
		return "welcome " + name + "( 유저Id : " + userId + ", 유저Pw : "+userPw+ "주민번호 : " + ssn + ")";
	}

}
