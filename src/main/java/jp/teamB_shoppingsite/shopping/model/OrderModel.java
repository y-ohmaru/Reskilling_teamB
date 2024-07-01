// 注文情報を保持するフィールド
// 並河弘樹20240614

package jp.teamB_shoppingsite.shopping.model;

public class OrderModel {
	private int order_id;
    private String item_name;
    private int order_item_val;
    private int item_amount;
    private String user_name;
    private String user_kana;
    private String user_email;
    private String user_post;
    private String user_address; 
    private String paymentMethod;

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getOrderId() {
        return this.order_id;
    }

    public void setItemName(String item_name) {
        this.item_name = item_name;
    }

    public String getItemName() {
        return this.item_name;
    }

    public void setOrderItemVal(int order_item_val) {
        this.order_item_val = order_item_val;
    }

    public int getOrderItemVal() {
        return this.order_item_val;
    }

    public void setItemAmount(int item_amount) {
        this.item_amount = item_amount;
    }

    public int getItemAmount() {
        return this.item_amount;
    }

    public void setOrderCusAddress1(String user_address) {
        this.user_address = user_address;
    }

    public String getOrderCusAddress() {
        return this.user_address;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getUserName() {
        return this.user_name;
    }

    public void setUserKana(String user_kana) {
        this.user_kana = user_kana;
    }

    public String getUserKana() {
        return this.user_kana;
    }

    public void setUserEmail(String user_email) {
        this.user_email = user_email;
    }

    public String getUserEmail() {
        return this.user_email;
    }

    public void setUserPost(String user_post) {
        this.user_post = user_post;
    }

    public String getUserPost() {
        return this.user_post;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }
}

