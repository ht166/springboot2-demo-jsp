package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.db.UserInfDB;
import com.example.demo.dto.UserInfDto;

@SpringBootApplication
public class DemoHelloJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHelloJspApplication.class, args);
		
//		管理者ユーザーをいれる
		UserInfDB.userInfDtoDB.add(new UserInfDto());
		UserInfDB.userInfDtoDB.get(0).setUserId("admin");
		UserInfDB.userInfDtoDB.get(0).setPassword("1234");
		
		
		
	}

}
