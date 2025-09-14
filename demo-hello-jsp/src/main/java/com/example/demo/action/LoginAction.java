package com.example.demo.action;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserInfDto;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

import jakarta.validation.Valid;

@RequestMapping(value = "/login")
@Controller
public class LoginAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * セッションスコープの ユーザー情報DTO
	 */
	@Autowired
	private UserInfDto sessionUser; 
	
	/**
	 * ログインサービス
	 */
	@Autowired
	private LoginService loginSerivce;
	
	/*
	 * ログイン画面JSP名
	 */
	String loginJSPName = "login/login";

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		logger.info("ログイン処理画面へ遷移");
		return loginJSPName;
	}

	@PostMapping("/auth")
	public String auth(@ModelAttribute("loginForm") @Valid LoginForm form, BindingResult bindingResult, Model model) {
		String userId = form.getUserId();
		String password = form.getPassword();
		logger.info("ログイン認証処理開始 ");
		logger.info("userId={}", userId);
		logger.info("password={}", password);
	
		if (bindingResult.hasErrors()) {
			logger.info("バリデーションエラー");
			return loginJSPName; // エラー時は再度フォーム表示
		}

		UserInfDto dbUser =loginSerivce.loginCheck(userId, password);
		
		if (dbUser!= null) {
			logger.info("ログイン成功");
			BeanUtils.copyProperties(dbUser, sessionUser);
			
			logger.info("welcomeへ遷移");
			return "redirect:/welcome/index";
		} else {
			model.addAttribute("message", "ユーザーIDまたはパスワードが間違っています");
			logger.info("ログイン失敗　画面を再読み込み");
			return loginJSPName;
		}
	}
	
    @GetMapping("/logout")
    public String logout() {
        // セッションスコープの DTO をリセット
        sessionUser.setUserId(null);
        sessionUser.setUserName(null);
        return "redirect:/login/index";
    }
    
}
