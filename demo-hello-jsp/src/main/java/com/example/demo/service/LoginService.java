package com.example.demo.service;

import com.example.demo.dto.UserInfDto;

public interface LoginService {
	/**
	 * ���O�C���`�F�b�N
	 * @param userId ���[�U�[ID
	 * @param password �p�X���[�h
	 * @return ���O�C���`�F�b�N����
	 */
	UserInfDto loginCheck(String userId,String password);
}
