package com.example.demo.db;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.UserInfDto;
/**
 * ユーザー情報のデータベース代わり
 * @author ht166
 *
 */
public class UserInfDB {
	public static List<UserInfDto> userInfDtoDB = new ArrayList<UserInfDto>();
	
	   static {
	        UserInfDto admin = new UserInfDto();
	        admin.setUserId("admin");
	        admin.setPassword("1234");
	        admin.setUserName("管理者");
	        admin.setMenuLevel(0);
	        userInfDtoDB.add(admin);

	        UserInfDto user1 = new UserInfDto();
	        user1.setUserId("user1");
	        user1.setPassword("abcd");
	        user1.setUserName("一般ユーザー");
	        user1.setMenuLevel(1);
	        userInfDtoDB.add(user1);
	    }
}
