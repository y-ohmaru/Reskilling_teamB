//ユーザーモデル
//並河 20240618

package jp.teamB_shoppingsite.shopping.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String user_id;
    private String user_name;
    private String user_kana;
    private String user_email;
    private String user_password;
    private String user_post;
    private String user_address;
    private String paymentMethod;
    private String card_Number;
    private String card_Name;
    private String card_Month;
    private String card_Year;
    private String securitycode;

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_kana() {
		return user_kana;
	}
	public void setUser_kana(String user_kana) {
		this.user_kana = user_kana;
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
	public String getUser_post() {
		return user_post;
	}
	public void setUser_post(String user_post) {
		this.user_post = user_post;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCard_Number() {
		return card_Number;
	}
	public void setCard_Number(String card_Number) {
		this.card_Number = card_Number;
	}
	public String getCard_Name() {
		return card_Name;
	}
	public void setCard_Name(String card_Name) {
		this.card_Name = card_Name;
	}
	public String getCard_Month() {
		return card_Month;
	}
	public void setCard_Month(String card_Month) {
		this.card_Month = card_Month;
	}
	public String getCard_Year() {
		return card_Year;
	}
	public void setCard_Year(String card_Year) {
		this.card_Year = card_Year;
	}
	public String getSecuritycode() {
		return securitycode;
	}
	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}


}