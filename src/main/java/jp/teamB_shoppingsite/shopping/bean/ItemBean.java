package jp.teamB_shoppingsite.shopping.bean;
//並河　20240613　商品Bean

import java.io.Serializable;

public class ItemBean implements Serializable {
    private int item_id;
    private String item_name;
    private int type_id;
    private int item_price;
    private int item_inventry;
    private String item_image;
    private String item_date;
    private String item_announce;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getItem_inventry() {
		return item_inventry;
	}
	public void setItem_inventry(int item_inventry) {
		this.item_inventry = item_inventry;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getItem_date() {
		return item_date;
	}
	public void setItem_date(String item_date) {
		this.item_date = item_date;
	}
	public String getItem_announce() {
		return item_announce;
	}
	public void setItem_announce(String item_announce) {
		this.item_announce = item_announce;
	}


}