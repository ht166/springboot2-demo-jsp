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
		logger.info("���[�U�[�ꗗ��ʂ֑J��");
		
	    // ���[�U�[�ꗗ�Ȃǂ��擾���� model �ɃZ�b�g
		List<UserInfDto> users = adminService.getAllUsers();
	    model.addAttribute("users", users);
	    
	    return "admin/users"; // admin/users.jsp ��\��
	}
	
//	TODO ������
	@GetMapping("/editUser")
	public String editUser(Model model) {
		return "admin/editUser";
	}
	
//	TODO ������
	@GetMapping("/createUser")
	public String createUser(Model model) {
		return "admin/user";
	}
	
//	TODO ������
	@PostMapping("/delete")
	public String deleteUser(Model model) {
		return "forward:/admin/users";
	}
	
	/**
	 * ���O�A�E�g����
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		
		return super.logout(req);
	}

}
