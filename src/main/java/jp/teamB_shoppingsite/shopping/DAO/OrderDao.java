/** 会員情報取得用DAO 2024/6/24 伊藤作成 */
package jp.teamB_shoppingsite.shopping.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.model.UserInfoModel;
import jp.teamB_shoppingsite.shopping.model.UserModel;

@Component
public class OrderDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int orderInsert(UserInfoModel userInfoModel, int total) {
		String sql = "INSERT INTO orders(user_id, total_amount, order_date, cancel_flg) VALUES(?,?,?,?)";
		Object[] parameters = {userInfoModel.getUser_id(), total, LocalDate.now(), 0};
		int order = jdbcTemplate.update(sql, parameters);
		return order;
	}

	public List<Integer> order(UserInfoModel userInfoModel) {
		String sql = "SELECT orders_id FROM orders WHERE user_id = ?";
		Object[] parameters = {userInfoModel.getUser_id()};
		List<Integer> order = jdbcTemplate.queryForList(sql, parameters, Integer.class);
		return order;
	}

	public int orderDetailInsert(UserModel userModel, int itemId, int total, int order_id) {
		String sql = "INSERT INTO order_detail(orders_id, item_id, order_item_val, order_cus_address, order_send, item_amount) VALUES(?,?,?,?,?,?)";
		Object[] parameters = {order_id, itemId, 1, userModel.getUser_address(), 0, total};
		int order = jdbcTemplate.update(sql, parameters);
		return order;
	}
}
