package com.example.demo.dto;

import java.security.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;
/**
 * ���[�U�[����DTO
 * @author ht166
 *
 */
@Component
@Getter
@Setter
@SessionScope
public class UserInfDto {
	/*
	 * ���[�U�[ID
	 */
	private String userId;
	
	/*
	 * �p�X���[�h
	 */
	private String password;
	
	/*
	 * ���[�U�[��
	 */
	private String userName;
	
	/*
	 * �o�^����
	 */
	private Timestamp redisterTime;
	
	/*
	 * ���j���[���x��
	 */
	
	private String menuLevel;
}
