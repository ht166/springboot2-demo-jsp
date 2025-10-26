package com.example.demo.form;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
/**
 * ���O�C���t�H�[��
 * @author ht166
 *
 */
@Getter
@Setter
public class LoginForm {
	@NotBlank(message="���[�U�[ID�͕K�{�ł�")
	private String userId;
	
	@NotBlank(message="�p�X���[�h�͕K�{�ł�")
    private String password;

}
