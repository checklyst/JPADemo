package com.training.user.responseBean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponse {
	
	@JsonProperty("response")
	Object response;

	public Object getResponse() {
		return response;
	}

	public void setResponse(UserResponseFields response) {
		this.response = response;
	}

}
