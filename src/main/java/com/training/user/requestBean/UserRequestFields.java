package com.training.user.requestBean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRequestFields {
	
	@NotBlank(message = "First Name must be mentioned.")
	@Pattern(regexp = "^[A-Za-z]+$", message = "First Name must be Alphabets")
	@JsonProperty("fname")
	private String first_name;
	
	
	@NotBlank(message = "Last Name must be mentioned.")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Last Name must be Alphabets")
	@JsonProperty("lname")
	private String last_name;
	
	@Email(message = "Email should be valid")
	@JsonProperty("email")
	private String email;

}
