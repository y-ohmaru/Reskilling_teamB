package jp.teamB_shoppingsite.shopping.model;

import java.io.Serializable;

public class RegistInfoChangeModel implements Serializable {

	private int user_id;
	private String user_name;
	private String user_email;
	private String user_password;
	private String new_password;
	private String new_passwordCheck;

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getNew_passwordCheck() {
		return new_passwordCheck;
	}
	public void setNew_passwordCheck(String new_passwordCheck) {
		this.new_passwordCheck = new_passwordCheck;
	}
}



