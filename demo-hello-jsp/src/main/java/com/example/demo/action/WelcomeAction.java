package com.example.demo.action;

import java.lang.invoke.MethodHandles;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserInfDto;
/**
 * welcome��ʂ̃R���g���[���[
 * @author ht166
 *
 */
@Controller
@RequestMapping(value="/welcome")
public class WelcomeAction extends BaseAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	/**
	 * �Z�b�V�����X�R�[�v�� ���[�U�[���DTO
	 */
	private final UserInfDto sessionUser; 
	
	public WelcomeAction(UserInfDto sessionUser) {
		this.sessionUser = sessionUser;
	}	
	
	@GetMapping("/index")
	public String index(Model model){
		
		model.addAttribute("sessionUser", sessionUser);
		
	    // menuLevel �ɉ����ăr���[��؂�ւ�
	    if(sessionUser != null && sessionUser.getMenuLevel() == 0){
			logger.info("�Ǘ��҃A�J�E���g��welcome��ʂ֑J��");
	        return "welcome/admin";   // �Ǘ��җp JSP
	    } else {
	    	logger.info("��ʃ��[�U�[�p��welcome��ʂ֑J��");
	        return "welcome/user";    // ��ʃ��[�U�[�p JSP
	    }
//		return "welcome/welcome";
	}
	
	/**
	 * ���O�A�E�g����
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		
		return super.logout(req);
	}

}
