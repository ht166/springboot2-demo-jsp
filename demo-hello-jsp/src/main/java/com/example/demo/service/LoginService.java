package com.example.demo.service;

import com.example.demo.dto.UserInfDto;

public interface LoginService {
	/**
	 * ログインチェック
	 * @param userId ユーザーID
	 * @param password パスワード
	 * @return ログインチェック結果
	 */
	UserInfDto loginCheck(String userId,String password);
}
