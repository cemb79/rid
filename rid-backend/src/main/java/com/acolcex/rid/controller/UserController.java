package com.acolcex.rid.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acolcex.rid.model.User;
import com.acolcex.rid.service.ServiceException;
import com.acolcex.rid.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(value = WebPaths.LOGIN, method = {RequestMethod.POST})
    @ResponseBody
	public ResponseEntity<?> login(@RequestBody Map<String, ?> data, HttpSession httpSession, HttpServletRequest request) {
		String id = (String) data.get("username");
		logger.info("Loging in user {}", id);
		ResponseEntity<?> response = null;
		try {
			User user = userService.findById(id);
			HashMap<String, Object> map = new HashMap<>();
			map.put("data", user);
			response = new ResponseEntity<>(map, HttpStatus.OK);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
		}
		
		return response;
	}
}
