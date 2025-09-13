package com.example.demo.action;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserInfDto;
/**
 * welcome画面のコントローラー
 * @author ht166
 *
 */
@Controller
@RequestMapping(value="/welcome")
public class WelcomeAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	/**
	 * セッションスコープの ユーザー情報DTO
	 */
	@Autowired
	private UserInfDto sessionUser; 
	
	@GetMapping("/index")
	public String index(Model model){
		
		model.addAttribute("sessionUser", sessionUser);
		
		logger.info("welcome画面へ遷移");
		return "welcome/welcome";
	}
	

}
