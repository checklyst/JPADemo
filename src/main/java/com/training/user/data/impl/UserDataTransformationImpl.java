package com.training.user.data.impl;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.user.data.UserDataTransformation;
import com.training.user.model.UserT;
import com.training.user.repository.UserTRepo;
import com.training.user.requestBean.UserRequest;
import com.training.user.requestBean.UserRequestFields;
import com.training.user.responseBean.UserResponseFields;

@Service
public class UserDataTransformationImpl implements UserDataTransformation {
	
	private static final Logger logger = LoggerFactory.getLogger(System.class);
	
	@Autowired
	UserTRepo userTRepo; // Inject userTRepo

	@Override
	public void userDataRequestTransform(UserRequest userRequest, UserResponseFields userResponseFields) {
	
		UserT userT = new UserT();
		
		UserRequestFields userRequestFields = userRequest.getUserRequestFields();
		createUserT(userRequestFields,userT);
		
	}

	private void createUserT(UserRequestFields userRequestFields, UserT userT) {
		
		try {
			
			Timestamp timestamp = new  Timestamp(new java.util.Date().getTime());

			userT.setFirst_name(userRequestFields.getFirst_name());
			userT.setLast_name(userRequestFields.getLast_name());
			userT.setEmail(userRequestFields.getEmail());
			userT.setStatus(1);
			
			userT = userTRepo.save(userT);

		} catch (Exception e) {

			logger.error("UserDataTransformationImpl:following error occurred in the createUserT() function :", e);
		}

	}

	@Override
	public void getUserDetailsByUserId(Integer userId, UserResponseFields userResponseFields) {
		
		try {

			UserT userT = userTRepo.findByUserId(userId);
			userResponseFields.setFname(userT.getFirst_name());
			userResponseFields.setLname(userT.getLast_name());
			userResponseFields.setEmail(userT.getEmail());
			userResponseFields.setCode(200);
			userResponseFields.setStatus("success");


		} catch (Exception e) {

			logger.error("UserDataTransformationImpl:following error occurred in the setUserDetailsByUserId function :", e);
		}
		
	}
	
	

}
