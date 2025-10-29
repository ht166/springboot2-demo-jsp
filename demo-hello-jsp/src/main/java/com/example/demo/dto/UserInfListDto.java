package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Getter;
import lombok.Setter;

@SessionScope
@Getter
@Setter
@Component
public class UserInfListDto {
    private List<UserInfDto> userList = new ArrayList<>();

    public void clear() {
        userList.clear();
    }
}
