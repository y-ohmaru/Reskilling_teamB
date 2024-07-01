package jp.teamB_shoppingsite.shopping.model;

import java.io.Serializable;

public class RegistModel implements Serializable {
	private String name;
	private String mail;
	private String mailCheck;
	private String password;
	private String passwordCheck;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMailCheck() {
		return mailCheck;
	}
	public void setMailCheck(String mailCheck) {
		this.mailCheck = mailCheck;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordCheck() {
		return passwordCheck;
	}
	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}


}
