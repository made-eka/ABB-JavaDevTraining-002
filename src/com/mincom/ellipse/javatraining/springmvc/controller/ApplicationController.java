/**
 * ABB Java Development Training 2016
 * Ant, Ivy, Spring MVC framework with data.
 */
package com.mincom.ellipse.javatraining.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.mincom.ellipse.javatraining.springmvc.model.*;
import com.mincom.ellipse.javatraining.springmvc.services.*;

/**
 * The controller class for the Spring MVC application.
 * 
 * @author IDEKNUG
 */
@Controller
public class ApplicationController {

	private static final String INDEX_PAGE_KEY = "index";
	private static final String FINAL_PAGE_KEY = "finalPage";
	private static final String ERROR_PAGE_KEY = "errorPage";
	private static final String DETAIL_PAGE_KEY = "detailPage";
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);
	private final String MESSAGE_MAP_KEY = "input_message";
	private final String ERROR_MAP_KEY = "error_message";
	private final String USER_LIST_KEY = "user_list";
	private final String USER_MAP_KEY = "user";
	private final String USER_MODE = "mode";

	@Autowired
	UserService userService;

	/**
	 * Method for handling the transition to the Welcome Page with login form.
	 * 
	 * @param model {@code ModelMap} object
	 * @return String of the INDEX_PAGE key
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute(MESSAGE_MAP_KEY, "");
		model.addAttribute(ERROR_MAP_KEY, "");
		Credential credential = new Credential();
		model.addAttribute("credential", credential);
		LOGGER.debug("Displaying page without input message");
		return INDEX_PAGE_KEY;
	}

	/**
	 * Method for handling the login processing. If login valid, user will be
	 * navigated to Final Page.
	 * 
	 * @param model {@code ModelMap} object
	 * @return String of redirect to Final Page if login succeeded.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Credential credential, ModelMap model) {

		boolean isValidUser = userService.checkLogin(credential.getUserName(), credential.getPassword());
		if (isValidUser) {
			return "redirect:/finalPage";
		} else {
			model.addAttribute(ERROR_MAP_KEY, "Incorrect username/password combination. Please retry.");
			return INDEX_PAGE_KEY;
		}
	}

	/**
	 * Method for handling process to display User details.
	 * 
	 * @param model {@code ModelMap} object
	 * @param input {@code String id} username as input request parameter
	 * @return String of the DETAIL_PAGE_KEY key
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable String id, @ModelAttribute User user, ModelMap model) {

		user = userService.getUser(id);
		model.addAttribute(USER_MAP_KEY, user);
		model.addAttribute(USER_MODE, "edit");
		populateDefaultModel(model);
		return DETAIL_PAGE_KEY;
	}

	/**
	 * Method for handling process to display blank form to add new user.
	 * 
	 * @param model {@code ModelMap} object
	 * @param input {@code String id} username as input request parameter
	 * @return String of the DETAIL_PAGE_KEY key
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String add(@ModelAttribute User user, ModelMap model) {

		User newUser = new User();
		model.addAttribute(USER_MAP_KEY, newUser);
		model.addAttribute(USER_MODE, "add");
		populateDefaultModel(model);
		return DETAIL_PAGE_KEY;
	}


	/**
	 * Method for handling the request parameter passed on the URL.
	 * 
	 * @param input {@code String} input request parameter 
	 * @param model {@code ModelMap} object
	 * @return String of the ERROR_PAGE key
	 */
	@RequestMapping(value = "/{input}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String input, ModelMap model) {

		if (input.isEmpty()) {
			return INDEX_PAGE_KEY;
		}

		model.addAttribute(MESSAGE_MAP_KEY, "Your typed URL is invalid. "
				+ "\nPlease click button Back.");

		return ERROR_PAGE_KEY;
	}

	/**
	 * Method for handling the transition to the Final Page with User list.
	 * 
	 * @param model {@code ModelMap} object
	 * @return String of the FINAL_PAGE key
	 */
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage(ModelMap model) {
		model.addAttribute(MESSAGE_MAP_KEY, "This is the final message to The Final Page" );
		List<User> userList = userService.getUserList();
		model.addAttribute(USER_LIST_KEY, userList);
		return FINAL_PAGE_KEY;
	}

	/**
	 * Method for handling the transition back to the Welcome Page.
	 * 
	 * @param model {@code ModelMap} object
	 * @return String of the INDEX_PAGE key
	 */
	@RequestMapping(value = "/backToIndex", method = RequestMethod.GET)
	public String back(ModelMap model) {
		model.addAttribute(MESSAGE_MAP_KEY, "Welcome back!");
		model.addAttribute(ERROR_MAP_KEY, "");
		Credential credential = new Credential();
		model.addAttribute("credential", credential);
		return INDEX_PAGE_KEY;
	}

	/**
	 * Method for handling the valid value for Gender.
	 * The values are "M" for Male and "F" for Female.
	 * 
	 * @param model {@code ModelMap} object
	 */
	private void populateDefaultModel(ModelMap model) {
		Map<String, String> gender = new LinkedHashMap<String, String>();
		gender.put("M", "Male");
		gender.put("F", "Female");
		model.addAttribute("genderList", gender);
	}

}