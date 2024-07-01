//	作業者:田邊大紀
//	作業日時:2024/6/17
//	概要:商品データテーブルアクセスオブジェクト


package jp.teamB_shoppingsite.shopping.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jp.teamB_shoppingsite.shopping.bean.ItemBean;


@Component
public class ItemsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//データベースとbeanの情報を紐づけ
	private RowMapper<ItemBean> itemsMapper =new BeanPropertyRowMapper<ItemBean>(ItemBean.class);

	//全件検索
	public List<ItemBean> getList(){
		String sql = "SELECT * FROM item";
		List<ItemBean> itemsList = jdbcTemplate.query(sql,itemsMapper);
		return itemsList;
	}

	//あいまい検索
	public List<ItemBean> getListByItemName(String item_name){
		String sql = "SELECT * FROM item WHERE item_name LIKE ?";
		item_name = item_name.replace("%", "\\%").replace("_", "\\_");
		item_name = "%" + item_name + "%";
		Object[] parameters = {item_name};
		List<ItemBean> itemsList = jdbcTemplate.query(sql, parameters, itemsMapper);
		return itemsList;
	}

	// ジャンル検索用メソッド
    public List<ItemBean> getItemtypeId(Integer type_id) {
        String sql = "SELECT * FROM item WHERE type_id = ?";
        Object[] parameters = {type_id};
        try {
            return jdbcTemplate.query(sql, parameters,  itemsMapper);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

 // ジャンル&あいまい検索用メソッド
    public List<ItemBean> getItemIDandName(Integer type_id , String item_name) {
        String sql = "SELECT * FROM item WHERE type_id = ? AND item_name LIKE ?";
        item_name = item_name.replace("%", "\\%").replace("_", "\\_");
		item_name = "%" + item_name + "%";
        Object[] parameters = {type_id,item_name};
        try {
            return jdbcTemplate.query(sql, parameters,  itemsMapper);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ItemBean> getItemId(Integer itemId) {
        String sql = "SELECT * FROM item WHERE item_id = ?";
        Object[] parameters = {itemId};
        try {
            return jdbcTemplate.query(sql, parameters, itemsMapper);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
