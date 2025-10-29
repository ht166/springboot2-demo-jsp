package com.example.demo.action.common;

import javax.servlet.http.HttpServletRequest;


public class BaseAction {
	   
	    protected String logout(HttpServletRequest req) {
	    	//セッション情報を削除してログアウト
	    	req.getSession().invalidate();
	        return "redirect:/login/index";
	    }
}
