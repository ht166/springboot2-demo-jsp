package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	@NotBlank(message="ユーザーIDは必須です")
	private String userId;
	
	@NotBlank(message="パスワードは必須です")
    private String password;

}
