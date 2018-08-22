package co.grandcircus.coffeeshop.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Items;

@Repository
public class ItemsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Items> findAll(){

		String sql = "SELECT * FROM Items";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Items.class));
	}
	
	
	public Items findById(Long id) {
		String sql = "SELECT * FROM Items WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Items.class), id);
	}
	
	public void create(Items items) {
		System.out.println("Create: " + items);
		String sql = "INSERT INTO Items (id, name, description, quantity, price) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, items.getId(), items.getName(), items.getDescription(), items.getQuantity(), items.getPrice());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM room WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
	
}
