package com.mincom.ellipse.javatraining.springmvc.dao;

import java.util.List;
import com.mincom.ellipse.javatraining.springmvc.model.User;

/**
 *
 * @author IDAGDHA
 */

public interface UserDao {
	public List<User> getUserList();

	public User getUser(String id);

	public void insertData(User user);

	public void updateData(User user);
}