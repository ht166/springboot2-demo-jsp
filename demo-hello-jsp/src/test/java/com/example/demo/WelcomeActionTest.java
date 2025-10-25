package com.example.demo;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.action.WelcomeAction;
import com.example.demo.dto.UserInfDto;

@SpringBootTest
@AutoConfigureMockMvc
class WelcomeActionTest {

	@Autowired
	private MockMvc mockMvc;

	@org.mockito.Mock
	private UserInfDto sessionUser;

	@Autowired
	private WelcomeAction welcomeAction;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		ReflectionTestUtils.setField(welcomeAction, "sessionUser", sessionUser);
	}

	@Test
	@DisplayName("管理者ユーザーならAdminビューが返り、Modelにユーザー情報が入る")
	void DisplayWelcomAdminTest() throws Exception {
		// モックのユーザー情報を設定
		org.mockito.Mockito.when(sessionUser.getMenuLevel()).thenReturn(0);
		org.mockito.Mockito.when(sessionUser.getUserName()).thenReturn("AdminUser");

		mockMvc.perform(get("/welcome/index"))
				.andDo(print())
				.andExpect(view().name("welcome/admin"))
				.andExpect(model().attributeExists("sessionUser"))
				.andExpect(model().attribute("sessionUser",
						org.hamcrest.Matchers.hasProperty("userName", is("AdminUser"))));
	}

	@Test
	@DisplayName("一般ユーザーならUserビューが返り、Modelにユーザー情報が入る")
	void DisplayWelcomUserTest() throws Exception {
		org.mockito.Mockito.when(sessionUser.getMenuLevel()).thenReturn(1);
		org.mockito.Mockito.when(sessionUser.getUserName()).thenReturn("NormalUser");

		mockMvc.perform(get("/welcome/index"))
				.andDo(print())
				.andExpect(view().name("welcome/user"))
				.andExpect(model().attributeExists("sessionUser"))
				.andExpect(model().attribute("sessionUser",
						org.hamcrest.Matchers.hasProperty("userName", is("NormalUser"))));
	}
}
