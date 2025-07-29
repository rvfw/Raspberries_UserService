package com.example.raspberriesUserService.dto;

import com.example.raspberriesUserService.enums.Role;
import lombok.Getter;

@Getter
public class UserRegisteredEvent {
    private Long id;
    private String name;
    private Role role;

    public UserRegisteredEvent(){}
    public UserRegisteredEvent(Long id,String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
}
