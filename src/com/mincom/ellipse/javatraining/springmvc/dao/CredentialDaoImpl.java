package com.mincom.ellipse.javatraining.springmvc.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 *
 * @author IDAGDHA
 */

public class CredentialDaoImpl implements CredentialDao {

	@Autowired
	DataSource dataSource;

	public boolean readCredential(String username, String password) {

		String query = "Select count(*) from credentials where username = ? and password = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		int count = jdbcTemplate.queryForObject(query, new Object[] { username, password }, Integer.class);

		return (count > 0);
	}

}