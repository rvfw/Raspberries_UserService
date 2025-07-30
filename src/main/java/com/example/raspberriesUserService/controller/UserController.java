package com.example.raspberriesUserService.controller;

import com.example.raspberriesUserService.model.User;
import com.example.raspberriesUserService.repository.UserRepository;
import com.example.raspberriesUserService.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("users")
    public ResponseEntity<Page<User>> getAllUsers(Pageable pageable, PagedResourcesAssembler<User> assembler) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers(pageable));
    }
    @GetMapping("user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
}
