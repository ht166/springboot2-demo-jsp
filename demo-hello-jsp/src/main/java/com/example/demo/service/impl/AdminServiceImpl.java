package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.db.UserInfDB;
import com.example.demo.dto.UserInfDto;
import com.example.demo.service.AdminService;

/**
 * �Ǘ��҃A�J�E���g�̃T�[�r�X�����������N���X
 * @author ht166
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	
	@Override
	public List<UserInfDto> getAllUsers() {
		
		return UserInfDB.userInfDtoDB;
	}

}
