package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.db.UserInfDB;
import com.example.demo.dto.UserInfDto;
import com.example.demo.form.UserSearchForm;
@Service
public class UserSearchService {
    public List<UserInfDto> search(UserSearchForm form) {
    	
        return UserInfDB.userInfDtoDB.stream()
                .filter(u -> form.getUserId() == null || u.getUserId().contains(form.getUserId()))
                .filter(u -> form.getUserName() == null || u.getUserName().contains(form.getUserName()))
                .filter(u -> form.getMenuLevel() == null || u.getMenuLevel().equals(form.getMenuLevel()))
                .collect(Collectors.toList());
    }
}
