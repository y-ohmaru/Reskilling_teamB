// 注文詳細モデル
// 並河 20240618


package jp.teamB_shoppingsite.shopping.model;

public class OrderDetailModel {
    private int order_detail_id;
    private int order_id;
    private int item_id;
    private int order_item_val;
    private String order_cus_address;
    private int order_send; //未発送：0　発送済み：1
    private int item_amount;

	public int getOrderDetailId() {
		return order_detail_id;
	}
	public void setOrderDetailId(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public int getOrderId() {
		return order_id;
	}
	public void setOrderId(int order_id) {
		this.order_id = order_id;
	}
	public int getItemId() {
		return item_id;
	}
	public void setItemId(int item_id) {
		this.item_id = item_id;
	}
	public int getOrderItemVal() {
		return order_item_val;
	}
	public void setOrderItemVal(int order_item_val) {
		this.order_item_val = order_item_val;
	}
	public String getOrderCusAddress() {
		return order_cus_address;
	}
	public void setOrderCusAddress(String order_cus_address) {
		this.order_cus_address = order_cus_address;
	}
	public int getOrderSend() {
		return order_send;
	}
	public void setOrderSend(int order_send) {
		this.order_send = order_send;
	}
	public int getItemAmount() {
		return item_amount;
	}
	public void ItemAmount(int item_amount) {
		this.item_amount = item_amount;
	}
}