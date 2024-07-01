package jp.teamB_shoppingsite.shopping.DAO;
//並河　カートDAO土台　20240614

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * カートDAOクラス.
 */
public class CartDao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public CartDao() throws SQLException {
        try {
            // JDBCドライバのロード
            // 「com.mysql.jdbc.Driver」クラス名
            Class.forName("com.mysql.jdbc.Driver");

            // データベースと接続
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping",
                    "user",
                    "password");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }

    /**
     * データベースから指定されたIDとパスワードを使ってユーザ情報を検索します.
     *
     * @param id    ログインID
     * @param pass  パスワード
     * @return  ユーザ情報（ResultSet）
     * @throws SQLException
     */
    public ResultSet selectUser(String user_id, String user_password) throws SQLException {
        // SQL文を生成
        this.ps = this.con.prepareStatement("select name, age from user where id = ? and pass = ?");

        // 生成したSQL文の「？」の部分にIDとパスワードをセット
        this.ps.setString(1, user_id);
        this.ps.setString(2, user_password);

        // SQLを実行
        this.rs = this.ps.executeQuery();

        return this.rs;
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