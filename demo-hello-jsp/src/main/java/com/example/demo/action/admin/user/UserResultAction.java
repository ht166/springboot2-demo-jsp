package com.example.demo.action.admin.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.UserInfListDto;
import com.example.demo.form.UserSearchForm;

@RequestMapping(value = "/admin/user/result")
@Controller
public class UserResultAction {
	/** ロガー */
	private static final Logger log = LoggerFactory.getLogger(UserResultAction.class);
	
	@Autowired
	private UserInfListDto userInfListDto;
	
	private static final String USER_RESULT_VIEW = "admin/user/result/result";
	private static final String REDIRECT_USER_SEARCH_VIEW = "redirect:/admin/user/search/index";
	
	@GetMapping("/index")
    public String index(Model model, HttpSession session) {
        UserSearchForm form = (UserSearchForm) session.getAttribute("userSearchForm");
        if (form == null) {
            return REDIRECT_USER_SEARCH_VIEW ;
        }

        model.addAttribute("searchForm", form);
        model.addAttribute("users", userInfListDto.getUserList());
        return  USER_RESULT_VIEW ;
	}
	
	@GetMapping("/returnSearch")
    public String returnSearch() {
		log.info("ユーザー検索条件入力画面へ戻る");
      return REDIRECT_USER_SEARCH_VIEW ;
	}
}
