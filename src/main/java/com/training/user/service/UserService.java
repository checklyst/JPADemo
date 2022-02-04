package com.training.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.user.requestBean.UserRequest;
import com.training.user.responseBean.UserResponseFields;

@Service
public interface UserService {
	
	void getUserById(int userId,UserResponseFields userResponseFields);
	void addUser(UserRequest userRequest, UserResponseFields userResponseFields);

}
