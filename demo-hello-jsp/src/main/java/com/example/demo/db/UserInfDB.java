package com.example.demo.db;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.UserInfDto;
/**
 * ���[�U�[���̃f�[�^�x�[�X����
 * @author ht166
 *
 */
public class UserInfDB {
	public static List<UserInfDto> userInfDtoDB = new ArrayList<UserInfDto>();
	
	   static {
	        UserInfDto admin = new UserInfDto();
	        admin.setUserId("admin");
	        admin.setPassword("1234");
	        admin.setUserName("�Ǘ���");
	        admin.setMenuLevel("0");
	        userInfDtoDB.add(admin);

	        UserInfDto user1 = new UserInfDto();
	        user1.setUserId("user1");
	        user1.setPassword("abcd");
	        user1.setUserName("��ʃ��[�U�[A");
	        user1.setMenuLevel("1");
	        userInfDtoDB.add(user1);
	        
	        UserInfDto user2 = new UserInfDto();
	        user2.setUserId("user2");
	        user2.setPassword("efgh");
	        user2.setUserName("��ʃ��[�U�[B");
	        user2.setMenuLevel("1");
	        userInfDtoDB.add(user2);
	    }
}
