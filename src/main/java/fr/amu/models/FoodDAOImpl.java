package fr.amu.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FoodDAOImpl implements FoodDAO{

	@Autowired
	JdbcTemplate jt;
	
	final  String INSERT_FOOD="INSERT INTO food(name,imgurl,tag,done) values(?,?,'NONE',false)";
	final  String SELECTALL_FOOD="SELECT * FROM food";  
	final  String DELETE_FOOD="DELETE FROM food WHERE id=?";
	final  String UPDATE_FOOD="UPDATE food SET tag=?, done=? WHERE id=?";
	final  String SELECTBYID_FOOD="SELECT * FROM food WHERE id=?";
	final  String SELECTBYDone_FOOD="SELECT * FROM food WHERE done=?";

	@Override
	public Integer add(Food food) {
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		  jt.update(connection -> {
		        PreparedStatement ps = connection
		          .prepareStatement(INSERT_FOOD);
		          ps.setString(1, food.getName());
		          ps.setString(2, food.getImg());
		          return ps;
		        }, keyHolder);
		return (Integer) keyHolder.getKey();
	}

	@Override
	public void update(Food food) {
	    FoodRowMapper foodMapper = new FoodRowMapper();
		jt.update(UPDATE_FOOD, food.getTag().toString(), food.isDone(), food.getId());
	}

	@Override
	public void delete(Integer id) {
		jt.update(DELETE_FOOD, id);
	}

	@Override
	public List<Food> findAll() {
		FoodRowMapper foodMapper = new FoodRowMapper();
		return jt.query(SELECTALL_FOOD, foodMapper);
	}

	@Override
	public Food findById(Integer id) {
		FoodRowMapper foodMapper = new FoodRowMapper();
		return jt.queryForObject(SELECTBYID_FOOD, foodMapper, id);
	}

	@Override
	public List<Food> findByTag(String tag) {
		return null;
	}

	@Override
	public List<Food> findByDone(boolean bool) {
		FoodRowMapper foodMapper = new FoodRowMapper();
		return jt.query(SELECTBYDone_FOOD, foodMapper, bool);
	}

	@Override
	public List<Food> findByTagAndDone(String tag, boolean done) {
		return null;
	}

}

class FoodRowMapper implements RowMapper<Food>
{
	@Override
	public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
		Food food = new Food();
		food.setId(rs.getInt("id"));
		food.setName(rs.getString("name"));
		food.setTag(rs.getString("tag"));
		food.setDone(rs.getBoolean("done"));
		food.setImg(rs.getString("imgurl"));
		return food;
	}
}

