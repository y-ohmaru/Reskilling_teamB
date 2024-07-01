package jp.teamB_shoppingsite.shopping.DAO;
//ショッピングDAO土台　並河　20240613

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ショッピングDAOクラス. DBの商品(item)テーブルを扱う
 */
public class ShoppingDao {
    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public ShoppingDao() throws SQLException {
        // JDBCドライバのロード
        try {
            // 「com.mysql.jdbc.Driver」クラス名
            Class.forName("com.mysql.jdbc.Driver");

            // データベースと接続
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_sample",
                    "user",
                    "password");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    /**
     * データベースの全商品と在庫を取得します.
     *
     * @return  商品情報（ResultSet）
     * @throws SQLException
     */
    public ResultSet selectItem() throws SQLException {
        // SQL文を生成
        this.ps = this.con.prepareStatement(
                "select item.item_id, item.item_name, item.item_price, item.item_inventry, item.item_image, "
                + "item.item_date, item.item_announce from item inner join stock on item.item_id = stock.item_id"
        );

        // SQLを実行
        this.rs = this.ps.executeQuery();

        return this.rs;
    }

    /**
     * 商品IDを基にデータベースの商品情報と在庫を取得します.
     *
     * @return  商品情報（ResultSet）
     * @param item_id 商品ID
     * @throws SQLException
     */
    public ResultSet selectItem(String item_id) throws SQLException {
        // SQL文を生成
        this.ps = this.con.prepareStatement(
                "select item.item_name, item.item_price, item.item_inventry "
                + "from item inner join stock on item.item_id = stock.item_id where item.item_id = ?"
        );
        // SQL文に商品IDを設定
        this.ps.setString(1, item_id);
        // SQLを実行
        this.rs = this.ps.executeQuery();

        return this.rs;
    }

    /**
     * 商品IDを基にデータベースの在庫を更新（マイナス）します.
     *
     * @param item_id;
     * @param order_item_val 購入数
     * @throws SQLException
     */
    public void updateItem(String item_id, int order_item_val) throws SQLException {
         // SQL文を生成
        /* update文を追加
         在庫から購入数を引く
         */
        this.ps = this.con.prepareStatement("update stock set quantity = quantity - ? where item_id = ?");

        // SQL文に数量を設定
        this.ps.setInt(1, order_item_val);
        // SQL文に商品IDを設定
        this.ps.setString(2, item_id);
        // SQLを実行
        this.ps.executeUpdate();
    }

    /**
     * コネクションをクローズします.
     */
    public void close() {
        try {
            // データベースとの接続を解除する
            if (this.con != null) {
                this.con.close();
            }
            if (this.ps != null) {
                this.ps.close();
            }
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException se) {
            // データベースとの接続解除に失敗した場合
            se.printStackTrace();
        }
    }
}