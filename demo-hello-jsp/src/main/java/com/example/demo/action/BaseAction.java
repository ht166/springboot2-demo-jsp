package com.example.demo.action;

import javax.servlet.http.HttpServletRequest;


public class BaseAction {
	   
	    protected String logout(HttpServletRequest req) {
	    	//�Z�b�V���������폜���ă��O�A�E�g
	    	req.getSession().invalidate();
	        return "redirect:/login/index";
	    }
}
