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
 * welcome��ʂ̃R���g���[���[
 * @author ht166
 *
 */
@Controller
@RequestMapping(value="/welcome")
public class WelcomeAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	/**
	 * �Z�b�V�����X�R�[�v�� ���[�U�[���DTO
	 */
	@Autowired
	private UserInfDto sessionUser; 
	
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
	

}
