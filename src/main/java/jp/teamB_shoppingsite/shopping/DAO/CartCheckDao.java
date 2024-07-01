/** カート内チェック用DAO 2024/6/17 諸橋作成*/

package jp.teamB_shoppingsite.shopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.model.CartCheckModel;

@Component
public class CartCheckDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<CartCheckModel> cartCheckMapper = new BeanPropertyRowMapper<CartCheckModel>(CartCheckModel.class);

	public CartCheckModel getItems(Integer item_id) {	//アイテムIDから商品情報を抽出するメソッド
		String sql = "SELECT * FROM item WHERE item_id = ? ";
		Object[] parameters = {item_id};
		CartCheckModel checks = jdbcTemplate.queryForObject(sql , parameters , cartCheckMapper);
		return checks;
	}
}