package com.banking.bean;

public class UserBean {
	private int id;
	private String name;
	private String email;
	private String username;
	private String password;
	private String mobile;
	private String aadhar;
	private String address;
	private String pin;
	private String state;
	private String role;
	
	
	public UserBean(String name, String email, String username, String password, String mobile, String aadhar,
			String address, String pin, String state, String role) {
		
		super();
		this.name = name;
		this.email = email;
		this.username=username;
		this.password = password;
		this.mobile = mobile;
		this.aadhar = aadhar;
		this.address = address;
		this.pin = pin;
		this.state = state;
		this.role = role;
	}

	public UserBean() {

	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", mobile=" + mobile + ", aadhar=" + aadhar + ", address=" + address + ", pin=" + pin
				+ ", state=" + state + ", role=" + role + "]";
	}


}