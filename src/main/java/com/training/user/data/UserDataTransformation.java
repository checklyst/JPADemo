package com.training.user.data;

import org.springframework.stereotype.Service;

import com.training.user.requestBean.UserRequest;
import com.training.user.responseBean.UserResponseFields;

@Service
public interface UserDataTransformation {
	
	void userDataRequestTransform(UserRequest userRequest, UserResponseFields userResponseFields);
	void getUserDetailsByUserId(Integer userId, UserResponseFields userResponseFields );


}
