package com.example.raspberriesUserService.dto;

import com.example.raspberriesUserService.model.User;
import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String name;
    private LocalDateTime registrationDate;
    private Double balance;
    private Double spent;
    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.registrationDate = user.getRegistrationDate();
        this.balance = user.getBalance();
        this.spent = user.getSpent();
    }
}
