/** 会員情報取得用DAO 2024/6/19 諸橋作成 */

package jp.teamB_shoppingsite.shopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.model.UserInfoModel;

@Component
public class UserInfoDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<UserInfoModel> userInfoMapper = new BeanPropertyRowMapper<UserInfoModel>(UserInfoModel.class);

	public UserInfoModel getUsers(String email) {
		String sql = "SELECT * FROM user WHERE user_email = ?";
		Object[] parameters = {email};
		UserInfoModel users = jdbcTemplate.queryForObject(sql , parameters , userInfoMapper);
		return users;
	}
}