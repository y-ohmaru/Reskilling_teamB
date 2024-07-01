/** カート内商品確認用モデル 2024/6/17 諸橋作成 */

package jp.teamB_shoppingsite.shopping.model;

import java.io.Serializable;

public class CartCheckModel implements Serializable {
	private int item_id;
	private String item_name;
	private int item_price;
	private String item_image;
	private int index;
	
	
	
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
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}


}
