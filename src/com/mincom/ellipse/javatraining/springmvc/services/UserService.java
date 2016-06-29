package com.mincom.ellipse.javatraining.springmvc.services;

import java.util.List;
import com.mincom.ellipse.javatraining.springmvc.model.User;

/**
 *
 * @author IDAGDHA
 */

public interface UserService {
	public List<User> getUserList();

	public User getUser(String id);

	public void insertData(User user);

	public void updateData(User user);

	public boolean checkLogin(String username, String password);
}