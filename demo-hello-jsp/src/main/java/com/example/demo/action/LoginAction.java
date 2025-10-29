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

@RequestMapping(value = "/login")
@Controller

public class LoginAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * ���O�C���T�[�r�X
	 */
	private final LoginService loginService;
	
	/**
	 * �Z�b�V�����X�R�[�v�� ���[�U�[���DTO
	 */
//	private UserInfDto sessionUser; 
	@Autowired
	private UserInfDto sessionUser;
	
	
	
	/*
	 * ���O�C�����JSP��
	 */
	private static final String LOGIN_JSP_NAME = "login/login";
	
	/**
	 *  LoginAction�̃R���X�g���N�^
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
		logger.info("���O�C��������ʂ֑J��");
		return LOGIN_JSP_NAME;
	}
	
	


	@PostMapping("/auth")
	public String auth(@ModelAttribute("loginForm") @Validated LoginForm form
			, BindingResult bindingResult, Model model) {
		String userId = form.getUserId();
		String password = form.getPassword();
		logger.info("���O�C���F�؏����J�n ");
		logger.info("userId={}", userId);
		logger.info("password={}", password);
		System.out.println("auth���\�b�h�F"+form);
		System.out.println(form.getTestDisplay());
		
		if (bindingResult.hasErrors()) {
			logger.info("�o���f�[�V�����G���[");
			return LOGIN_JSP_NAME; // �G���[���͍ēx�t�H�[���\��
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
//			novelList.setNovelName1("�V�����");
			
			
			return LOGIN_JSP_NAME;
		}
	}
	
 
    
}
