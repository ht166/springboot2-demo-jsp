package com.example.demo.action;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.db.UserInfDB;
import com.example.demo.form.LoginForm;

import jakarta.validation.Valid;

@RequestMapping(value = "/login")
@Controller
public class LoginAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//	@Autowired
//	private UserInfDto sessionUser; // セッションスコープの DTO
	
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
		
//		管理者ユーザーの情報を取得
		String adminUserId = UserInfDB.userInfDtoDB.get(0).getUserId();
		String adminPassword = UserInfDB.userInfDtoDB.get(0).getPassword ();
		
		if (adminUserId.equals(userId) && adminPassword.equals(password)) {
			model.addAttribute("message", "ログイン成功");
			logger.info("welcomeへ遷移");
			return "forward:/welcome/index";
		} else {
			model.addAttribute("message", "ログイン失敗");
			logger.info("login画面を再読み込み");
			return loginJSPName;
		}
	}

}
