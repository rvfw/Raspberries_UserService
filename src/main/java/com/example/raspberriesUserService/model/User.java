package com.example.raspberriesUserService.model;

import com.example.raspberriesUserService.dto.UserDto;
import com.example.raspberriesUserService.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="users",indexes = @Index(columnList="email",unique=true))
@Data
public class User {
    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
    @CreationTimestamp
    private LocalDateTime registrationDate;

    @Column(nullable = false)
    private Double balance;
    @Column(nullable = false)
    private Double spent;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Role role;

    public User() {}
    public UserDto toDto(){
        return new UserDto(this);
    }
    public User(Long id, String name,Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.balance=0.0;
        this.spent=0.0;
    }
}
