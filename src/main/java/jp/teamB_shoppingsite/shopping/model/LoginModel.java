package jp.teamB_shoppingsite.shopping.model;

import java.io.Serializable;

public class LoginModel implements Serializable {

	private String user_email;
	private String user_password;
	private int user_join;

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
	public int getUser_join() {
		return user_join;
	}
	public void setUser_join(int user_join) {
		this.user_join = user_join;
	}


}