package jp.teamB_shoppingsite.shopping.bean;
//ユーザーBean　並河　20240613

import java.io.Serializable;

public class LoginUserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user_id;
    private String user_name;
    private String user_kana;
    private String user_email;
    private String user_password;
    private int user_join;
    private int user_point;
    private String user_post;
    private String user_address;


    public LoginUserBean(String user_id, String user_name, String user_kana, String user_email, String user_password,
    		int user_join, int user_point, String user_post, String user_address) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_kana = user_kana;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_join = user_join;
        this.user_point = user_point;
        this.user_post = user_post;
        this.user_address = user_address;
    }

    public void setId(String user_id){
        this.user_id = user_id;
    }

    public String getId(){
        return this.user_id;
    }

    public void setName(String user_name){
        this.user_name = user_name;
    }

    public String getName(){
        return this.user_name;
    }

    public void setKana(String user_kana){
        this.user_kana = user_kana;
    }

    public String getKana(){
        return this.user_kana;
    }

    public void setEmail(String user_email){
        this.user_email = user_email;
    }

    public String getMail(){
        return this.user_email;
    }

    public void setPassword(String user_password){
        this.user_password = user_password;
    }

    public String getPassword(){
        return this.user_password;
    }

    public void setJoin(int user_join){
        this.user_join = user_join;
    }

    public int getJoin(){
        return this.user_join;
    }

    public void setPoint(int user_point){
        this.user_point = user_point;
    }

    public int getPoint(){
        return this.user_point;
    }

    public void setPost(String user_post){
        this.user_post = user_post;
    }

    public String getPost(){
        return this.user_post;
    }

    public void setAddress(String user_address){
        this.user_address = user_address;
    }

    public String getAddress(){
        return this.user_address;
    }

}