package com.example.raspberriesUserService.repository;

import com.example.raspberriesUserService.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @NotNull
    Optional<User> findById(@NotNull Long id);

}
