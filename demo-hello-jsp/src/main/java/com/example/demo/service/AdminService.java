package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserInfDto;
/**
 * �Ǘ��҃A�J�E���g�̃T�[�r�X
 * @author ht166
 *
 */
public interface AdminService {
	/**
	 * ���[�U�[�ꗗ���擾
	 * @return ���[�U�[�ꗗ
	 */
	public  List<UserInfDto> getAllUsers();
}
