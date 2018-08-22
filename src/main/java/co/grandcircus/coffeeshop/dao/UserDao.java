package co.grandcircus.coffeeshop.dao;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.User;


@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll(){

		String sql = "SELECT * FROM User";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
	}
	
	
	public User findById(Long id) {
		String sql = "SELECT * FROM User WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
	}
	
	public void create(User user) {
		System.out.println("Create: " + user);
		String sql = "INSERT INTO User (first, last, email, phone, password, age, date ,username) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getFirst(), user.getLast(), user.getEmail(), user.getPhone(), user.getPassword(),
				user.getAge(), user.getDate(), user.getUsername());
	}
	
	public void delete(Long id) {
		String sql = "DELETE FROM room WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
	
}
