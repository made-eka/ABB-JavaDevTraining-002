package com.mincom.ellipse.javatraining.springmvc.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mincom.ellipse.javatraining.springmvc.model.User;
import com.mincom.ellipse.javatraining.springmvc.jdbc.UserRowMapper;

/**
 *
 * @author IDAGDHA
 */

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from users";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from users where username = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new Object[] { id }, new UserRowMapper());
		return userList.get(0);
	}

	public void insertData(User user) {
		String sql = "insert into users values (?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[] { user.getUserName(), user.getEmail(), user.getAddress(), user.getAge(),
				user.getGender(), user.getDivision() });
	}

	public void updateData(User user) {
		String sql = "update users set email = ?, address = ?, age = ?, gender = ?, "
				+ "division = ? where username = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql, new Object[] { user.getEmail(), user.getAddress(), user.getAge(), user.getGender(),
				user.getDivision(), user.getUserName() });
	}

}