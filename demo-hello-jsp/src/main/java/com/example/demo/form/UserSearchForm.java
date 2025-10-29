package com.example.demo.form;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchForm implements Serializable {
	private String userId;
    private String userName;
    private Integer menuLevel;
}
