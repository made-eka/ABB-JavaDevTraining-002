package com.mincom.ellipse.javatraining.springmvc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.mincom.ellipse.javatraining.springmvc.model.User;

/**
 *
 * @author IDAGDHA
 */

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserName(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setAddress(rs.getString("address"));
		user.setAge(rs.getInt("age"));
		user.setGender(rs.getString("gender"));
		user.setDivision(rs.getString("division"));
		return user;
	}

}
