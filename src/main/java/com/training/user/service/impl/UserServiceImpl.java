package com.training.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.user.data.UserDataTransformation;
import com.training.user.enumConstant.CommonMessageEnum;
import com.training.user.requestBean.UserRequest;
import com.training.user.responseBean.UserResponseFields;
import com.training.user.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(System.class);
	
	@Autowired
	UserDataTransformation userDataTransform;

	@Override
	public void getUserById(int userId,UserResponseFields userResponseFields) {
		
		try {

			
			userDataTransform.getUserDetailsByUserId(userId,userResponseFields);
			userResponseFields.setCode(200);
			userResponseFields.setStatus("success");
			userResponseFields.getFname();
			userResponseFields.getLname();
			userResponseFields.getEmail();


		} catch (Exception e) {
			logger.error("UserServiceImpl:following error occurred in the getUserDetailsByUserId function :", e);
			userResponseFields.setCode(500);
			userResponseFields.setStatus("success");
			userResponseFields.setMessage(CommonMessageEnum.DATA_FETCHED_FAILED.getValue());
			
		}
		
	}

	@Override
	public void addUser(UserRequest userRequest, UserResponseFields userResponseFields) {
		try
		{

			
			userDataTransform.userDataRequestTransform(userRequest,userResponseFields);
			userResponseFields.setCode(200);
			userResponseFields.setMessage(CommonMessageEnum.RECORD_INSERT_SUCCESS.getValue());
			userResponseFields.setStatus("success");
				

		}
		catch(Exception e)
		{
			logger.error("UserServiceImpl:following error occurred in the registerUser function :", e);
			userResponseFields.setCode(500);
			userResponseFields.setStatus("success");
			userResponseFields.setMessage(CommonMessageEnum.RECORD_INSERT_ERROR.getValue());
				
		}
		
	}


	
	

}
