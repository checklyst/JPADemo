package com.training.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.user.requestBean.UserRequest;
import com.training.user.responseBean.UserResponse;
import com.training.user.responseBean.UserResponseFields;
import com.training.user.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/v1/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(System.class);
	
	@Autowired
	UserService userService;
	
	
	@GetMapping(value = "/userid/{userId}", produces = "application/json")
	UserResponse getuserById(@PathVariable("userId") int userId) {
		
		UserResponse userResponse = new UserResponse();
		UserResponseFields userResponseFields = new UserResponseFields();
		userResponse.setResponse(userResponseFields);
		userService.getUserById(userId, userResponseFields);
		return userResponse;
	}
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json"  )
	UserResponse addUser(@RequestBody UserRequest userRequest) {
		
		UserResponse userResponse = new UserResponse();
		UserResponseFields userResponseFields = new UserResponseFields();
		userResponse.setResponse(userResponseFields);
		userService.addUser(userRequest,userResponseFields);
		return userResponse;
	}

	// handleMethodArgumentNotValid function with parameter MethodArgumentNotValidException is used for handling invalid user request
		@ResponseBody
		@ResponseStatus(value = HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class) public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex)
		{
			Map<String, String> errors = new HashMap<>();

			ex.getBindingResult().getFieldErrors().forEach(error ->
					errors.put(error.getField(), error.getDefaultMessage()));
			logger.error("Error occurred in the request json :", errors);
			return errors;
		}
}


