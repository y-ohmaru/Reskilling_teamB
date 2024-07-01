//個人情報変更用DAO   石田
package jp.teamB_shoppingsite.shopping.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.model.RegistInfoChangeModel;

@Component
public class RegistInfoChangeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<RegistInfoChangeModel> registInfoChangeMapper = new BeanPropertyRowMapper<RegistInfoChangeModel>(RegistInfoChangeModel.class);
	//対象の行を取り出す
		public RegistInfoChangeModel getUsers(String email) {
			String sql = "SELECT * FROM user WHERE user_email = ?";
			Object[] parameters = {email};
			RegistInfoChangeModel users = jdbcTemplate.queryForObject(sql , parameters , registInfoChangeMapper);
			return users;
		}

		//個人情報の変更を入力
		public void registChange(String name , String email , String password , String oldEmail) {
			String sql = "UPDATE user SET user_name = ? ,user_email = ? ,user_password = ? WHERE user_email = ?";
			Object[] parameters = {name,email,password,oldEmail};
			jdbcTemplate.update(sql , parameters);
		}

		public void toSecession(String email) {
			String sql = "UPDATE user SET user_join = 0 WHERE user_email = ?";
			Object[] parameters = {email};
			jdbcTemplate.update(sql , parameters);
		}

}


