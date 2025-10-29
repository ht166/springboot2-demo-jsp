package com.example.demo.action.admin.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.action.common.BaseAction;
import com.example.demo.dto.UserInfDto;
import com.example.demo.dto.UserInfListDto;
import com.example.demo.form.UserSearchForm;
import com.example.demo.service.UserSearchService;
@RequestMapping(value = "/admin/user/search")
@Controller
public class UserSearchAction extends BaseAction {
	/** ���K�[ */
	private static final Logger log = LoggerFactory.getLogger(UserSearchAction.class);
	
	private static final String USER_SEARCH_VIEW = "admin/user/search/search";
	private static final String REDIRECT_USER_RESULT_VIEW = "redirect:/admin/user/result/index";
	
    private final UserSearchService userSearchService;
    
    @Autowired
    private UserInfListDto userInfListDto;
    
    @ModelAttribute("userSearchForm")
    UserSearchForm setUserSearchForm() {
    	return new UserSearchForm();
    }
    /**
     * �R���X�g���N�^
     * @param userSearchService
     */
    public UserSearchAction(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }
    
    @GetMapping("/index")
    public String index() {
        log.info("���[�U�[�����������͉�ʂ֑J��");
        return USER_SEARCH_VIEW;
    }

    @PostMapping("/search")
    public String search(@ModelAttribute UserSearchForm form, HttpSession session) {
        session.setAttribute("userSearchForm", form);
        log.info("���[�U�[���������@�J�n");
        // Service�Ō������s
        List<UserInfDto> results = userSearchService.search(form);

        // ���ʂ�Session�X�R�[�vDTO�Ɋi�[
        userInfListDto.setUserList(results);
        
        log.info("���[�U�[���������@�I��");
        // �������ʉ�ʂփ��_�C���N�g
        return REDIRECT_USER_RESULT_VIEW;
    }
}
