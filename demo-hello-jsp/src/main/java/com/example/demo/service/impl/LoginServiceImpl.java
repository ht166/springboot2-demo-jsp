package com.example.demo.service.impl;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.db.UserInfDB;
import com.example.demo.dto.UserInfDto;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Override
	public UserInfDto loginCheck(String userId, String password) {
		logger.info("ログインチェック開始");
		UserInfDto dbUser = UserInfDB.userInfDtoDB.stream()
			    .filter(u -> u.getUserId().equals(userId))
			    .findFirst()
			    .orElse(null);

			if(dbUser != null && dbUser.getPassword().equals(password)) {
				logger.info("ログインチェック成功");
			   return dbUser;
			}
			
			logger.info("ログインチェック失敗");
		return null;
	}

}
