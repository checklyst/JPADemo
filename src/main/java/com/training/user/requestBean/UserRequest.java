package com.training.user.requestBean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;



public class UserRequest {
	

	@NotNull (message = "Sorry, Bad user request.")
	@JsonProperty("request")
	@Valid
	UserRequestFields  userRequestFields;
	
	
	boolean validate;
	
	public boolean isValidate() {
		return validate;
	}
	
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	
	public UserRequestFields getUserRequestFields() {
		return userRequestFields;
	}
	
	public void setUserRequestFields(UserRequestFields  userRequestFields) {
		this.userRequestFields = userRequestFields;
	}

}
