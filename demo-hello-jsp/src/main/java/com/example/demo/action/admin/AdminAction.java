package com.example.demo.action.admin;

import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.action.common.BaseAction;
import com.example.demo.dto.UserInfDto;
import com.example.demo.service.AdminService;


@Controller
@RequestMapping(value ="/admin")
public class AdminAction extends BaseAction {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private final AdminService adminService;
	
	public AdminAction(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		logger.info("ユーザー一覧画面へ遷移");
		
	    // ユーザー一覧などを取得して model にセット
		List<UserInfDto> users = adminService.getAllUsers();
	    model.addAttribute("users", users);
	    
	    return "admin/users"; // admin/users.jsp を表示
	}
	
//	TODO 未完成
	@GetMapping("/editUser")
	public String editUser(Model model) {
		return "admin/editUser";
	}
	
//	TODO 未完成
	@GetMapping("/createUser")
	public String createUser(Model model) {
		return "admin/user";
	}
	
//	TODO 未完成
	@PostMapping("/delete")
	public String deleteUser(Model model) {
		return "forward:/admin/users";
	}
	
	/**
	 * ログアウト処理
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		
		return super.logout(req);
	}

}
