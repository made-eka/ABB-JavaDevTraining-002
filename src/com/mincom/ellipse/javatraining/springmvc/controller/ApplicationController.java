/**
 * ABB Java Development Training 2016
 * Ant, Ivy, Spring MVC framework with data.
 */
package com.mincom.ellipse.javatraining.springmvc.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);
	private final String MESSAGE_MAP_KEY = "input_message";
	
	/**
	 * Method for handling the transition to the Welcome Page.
	 * 
	 * @param model {@code ModelMap} object
	 * @return String of the INDEX_PAGE key
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
 
		model.addAttribute(MESSAGE_MAP_KEY, "");
		LOGGER.debug("Displaying page without input message");
 
		return INDEX_PAGE_KEY;
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
	 * Method for handling the transition to the Final Page.
	 * 
	 * @param model {@code ModelMap} object
	 * @return String of the FINAL_PAGE key
	 */
	@RequestMapping(value = "/finalPage", method = RequestMethod.GET)
	public String finalPage(ModelMap model) {
		model.addAttribute(MESSAGE_MAP_KEY, "This is the final message to The Final Page" );
		
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
		return INDEX_PAGE_KEY;
	}
 
}