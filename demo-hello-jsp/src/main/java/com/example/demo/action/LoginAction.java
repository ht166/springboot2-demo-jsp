package com.example.demo.action;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserInfDto;
import com.example.demo.form.LoginForm;
import com.example.demo.service.LoginService;

@RequestMapping(value = "/login")
@Controller
public class LoginAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * �Z�b�V�����X�R�[�v�� ���[�U�[���DTO
	 */
//	@Autowired
//	private UserInfDto sessionUser; 
	private final UserInfDto sessionUser;
	    
	/**
	 * ���O�C���T�[�r�X
	 */
//	@Autowired
//	private LoginService loginSerivce;
	private final LoginService loginService;
	/*
	 * ���O�C�����JSP��
	 */
	String loginJSPName = "login/login";
	
	public LoginAction(LoginService loginService, UserInfDto sessionUser) {
	        this.loginService = loginService;
	        this.sessionUser = sessionUser;
	    }
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		logger.info("���O�C��������ʂ֑J��");
		return loginJSPName;
	}

	@PostMapping("/auth")
	public String auth(@ModelAttribute("loginForm") @Validated LoginForm form, BindingResult bindingResult, Model model) {
		String userId = form.getUserId();
		String password = form.getPassword();
		logger.info("���O�C���F�؏����J�n ");
		logger.info("userId={}", userId);
		logger.info("password={}", password);
	
		if (bindingResult.hasErrors()) {
			logger.info("�o���f�[�V�����G���[");
			return loginJSPName; // �G���[���͍ēx�t�H�[���\��
		}

		UserInfDto dbUser =loginService.loginCheck(userId, password);
		
		if (dbUser!= null) {
			logger.info("���O�C������");
			BeanUtils.copyProperties(dbUser, sessionUser);
			
			logger.info("welcome�֑J��");
			return "redirect:/welcome/index";
		} else {
			model.addAttribute("message", "���[�U�[ID�܂��̓p�X���[�h���Ԉ���Ă��܂�");
			logger.info("���O�C�����s�@��ʂ��ēǂݍ���");
			return loginJSPName;
		}
	}
	
 
    
}
