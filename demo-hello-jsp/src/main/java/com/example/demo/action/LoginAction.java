package com.example.demo.action;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.action.common.BaseAction;
import com.example.demo.dto.UserInfDto;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

@RequestMapping(value = "/demo-hello-jsp/login")
@Controller

public class LoginAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * ログインサービス
	 */
	private final LoginService loginService;
	
	/**
	 * セッションスコープの ユーザー情報DTO
	 */
//	private UserInfDto sessionUser; 
	@Autowired
	private UserInfDto sessionUser;
	
	
	
	/*
	 * ログイン画面JSP名
	 */
	private static final String LOGIN_JSP_NAME = "login/login";
	
	/**
	 *  LoginActionのコンストラクタ
	 * @param loginService
	 */
	public LoginAction(LoginService loginService) {
	        this.loginService = loginService;
	}
	
	@ModelAttribute("loginForm") 
	LoginForm setLoginForm() {
		return new LoginForm();
	}
	
	@GetMapping("/index")
	public String index() {
		logger.info("ログイン処理画面へ遷移");
		return LOGIN_JSP_NAME;
	}
	
	


	@PostMapping("/auth")
	public String auth(@ModelAttribute("loginForm") @Validated LoginForm form
			, BindingResult bindingResult, Model model) {
		String userId = form.getUserId();
		String password = form.getPassword();
		logger.info("ログイン認証処理開始 ");
		logger.info("userId={}", userId);
		logger.info("password={}", password);
		System.out.println("authメソッド："+form);
		System.out.println(form.getTestDisplay());
		
		if (bindingResult.hasErrors()) {
			logger.info("バリデーションエラー");
			return LOGIN_JSP_NAME; // エラー時は再度フォーム表示
		}
		UserInfDto dbUser =loginService.loginCheck(userId, password);
		
		if (dbUser!= null) {
			logger.info("ログイン成功");
			BeanUtils.copyProperties(dbUser, sessionUser);
			
			logger.info("welcomeへ遷移");
			
			return "redirect:/demo/welcome/index";
		} else {
			model.addAttribute("message", "ユーザーIDまたはパスワードが間違っています");
			logger.info("ログイン失敗　画面を再読み込み");
//			novelList.setNovelName1("坊ちゃん");
			
			
			return LOGIN_JSP_NAME;
		}
	}
	
 
    
}
