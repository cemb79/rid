package com.acolcex.rid.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acolcex.rid.controller.util.ApiResponse;
import com.acolcex.rid.model.User;
import com.acolcex.rid.service.ServiceException;
import com.acolcex.rid.service.UserService;
import com.acolcex.rid.util.WebUtils;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(WebPaths.LOGIN)
    public String showLogin(ModelMap model, Locale locale, HttpServletRequest request, HttpServletResponse response) {
		String url = ((HttpServletRequest) request).getRequestURL().toString();
        String domain = WebUtils.getDomain(url);
        logger.debug("Domain URL: {}", domain);
        logger.debug("Navigating to Login Page");
		return "login";
	}
	
	@PostMapping(WebPaths.LOGIN)
    @ResponseBody
	public ApiResponse login(@RequestBody Map<String, ?> data, HttpSession httpSession, HttpServletRequest request) {
		String id = (String) data.get("username");
		logger.info("Processing Login for user {}", id);
		ApiResponse response = null;
		try {
			User user = userService.findById(id);
			HashMap<String, Object> map = new HashMap<>();
			map.put("data", user);
			return ApiResponse.successResponse(user);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			response = ApiResponse.errorResponse(e.getMessage());
		}
		
		return response;
	}
	
	@RequestMapping(value = WebPaths.USER_FIND, method = {RequestMethod.GET})
	@ResponseBody
    public ApiResponse userById(@PathVariable String id) {
		logger.info("Finding user by id {}", id);
		ApiResponse response = null;
		try {
			User user = userService.findById(id);
			response = ApiResponse.successResponse(user);
		} catch (ServiceException e) {
			logger.error(e.getMessage());
			response = ApiResponse.errorResponse(e.getMessage());
		}
		return response;
	}
}
