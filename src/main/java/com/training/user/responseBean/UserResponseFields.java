package com.training.user.responseBean;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserResponseFields {
	
	@JsonProperty("code")
	private int code;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("user_id")
	private int userid;
	
	@JsonProperty("fname")
	private String fname;
	
	@JsonProperty("lname")
	private String lname;
	
	@JsonProperty("email")
	private String email; 
	
	@JsonProperty("message") 
	private String message;
	


}


