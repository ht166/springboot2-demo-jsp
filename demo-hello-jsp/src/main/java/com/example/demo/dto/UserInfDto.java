package com.example.demo.dto;

import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SessionScope
public class UserInfDto {
	private String userId;
	private String password;
	private int redisterDay; 
}
