package com.mincom.ellipse.javatraining.springmvc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.mincom.ellipse.javatraining.springmvc.dao.UserDao;
import com.mincom.ellipse.javatraining.springmvc.model.User;
import com.mincom.ellipse.javatraining.springmvc.dao.CredentialDao;

/**
 *
 * @author IDAGDHA
 */

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Autowired
	CredentialDao credentialdao;

	public List<User> getUserList() {
		return userdao.getUserList();
	}

	public User getUser(String id) {
		return userdao.getUser(id);
	}

	public void insertData(User user) {
		userdao.insertData(user);
	}

	public void updateData(User user) {
		userdao.updateData(user);
	}

	public boolean checkLogin(String username, String password) {
		return credentialdao.readCredential(username, password);
	}

}
