package com.lytear.springTest.lesson05.model;

public class Member {

	// DB에 있는 정보 저장해서 가져올 때. DB의 칼럼명과 일치하는 변수를 만듦
	private String name;
	private String phoneNumber;
	private String nationality;
	private String email;
	private String introduce;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
	
	
	
	
}
