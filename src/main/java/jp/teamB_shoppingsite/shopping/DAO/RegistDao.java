package jp.teamB_shoppingsite.shopping.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.model.RegistModel;

//並河　ログインDAO土台　20240613
//諸橋 6/14編集

/**
 * ログインDAOクラス.
 */
@Component
public class RegistDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(RegistModel registModel) {
		String sql = "INSERT INTO user(user_name, user_kana, user_email, user_password, user_join, user_point, user_post, user_address) VALUES(?,?,?,?,?,?,?,?)";
		Object[] parameters = {registModel.getName(), registModel.getName(), registModel.getMail(), registModel.getPassword(), 1, 0, "none", "none"};
		int user = jdbcTemplate.update(sql , parameters);
		return user;
	}

}