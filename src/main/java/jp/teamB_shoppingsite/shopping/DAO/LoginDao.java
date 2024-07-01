package jp.teamB_shoppingsite.shopping.DAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.model.LoginModel;

//並河　ログインDAO土台　20240613
//諸橋 6/14編集

/**
 * ログインDAOクラス.
 */
@Component
public class LoginDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private RowMapper<LoginModel> loginMapper = new BeanPropertyRowMapper<LoginModel>(LoginModel.class);

	public LoginModel getUsers(String email , String password) {
		String sql = "SELECT * FROM user WHERE user_email = ? AND user_password = ?";
		Object[] parameters = {email,password};
		LoginModel users = jdbcTemplate.queryForObject(sql , parameters , loginMapper);
		return users;
	}


}