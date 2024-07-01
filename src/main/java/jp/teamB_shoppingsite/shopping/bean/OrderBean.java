package jp.teamB_shoppingsite.shopping.bean;
//並河　20240613　注文Bean

import java.io.Serializable;

public class OrderBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int order_detail_id;
    private int order_id;
    private int item_id;
    private int order_item_val;
    private String order_cus_address;
    private int order_send;
    private int item_amount;



    public OrderBean(int order_detail_id, int order_id, int item_id, int order_item_val, String order_cus_address,
    		int order_send, int item_amount) {
    	this.item_id = item_id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.order_item_val = order_item_val;
        this.order_cus_address = order_cus_address;
        this.order_send = order_send;
        this.item_amount = item_amount;

    }

    public void setOrderDetailId(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getOrderDetailId() {
        return this.order_detail_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getItemName() {
        return this.order_id;
    }

    public void setItemId(int item_id) {
        this.item_id = item_id;
    }

    public int getItemId() {
        return this.item_id;
    }

    public void setOrderItemVal(int order_item_val) {
        this.order_item_val = order_item_val;
    }

    public int getPrice() {
        return this.order_item_val;
    }

    public void setOrderCusAddress(String order_cus_address) {
        this.order_cus_address = order_cus_address;
    }

    public String getOrderCusAddress() {
        return this.order_cus_address;
    }

    public void setOrderSend(int order_send) {
        this.order_send = order_send;
    }

    public int getOrderSend() {
        return this.order_send;
    }

    public void setItemAmount(int item_amount) {
        this.item_amount = item_amount;
    }

    public int getDate() {
        return this.item_amount;
    }

}