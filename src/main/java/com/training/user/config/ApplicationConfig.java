package com.training.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
public class ApplicationConfig {
	
	private String apiKey;

    public ApplicationConfig(@Value("{api.subcription.key}") String apiKey) {
    		
    	this.apiKey = apiKey;
    }


}
