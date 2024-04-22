package com.shop.service;

import com.shop.domain.dto.request.UserLoginRequest;
import com.shop.domain.dto.user.UserCreateDto;
import com.shop.domain.dto.user.UserUpdateDto;
import com.shop.domain.entity.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findUserById(Integer userId);

    Optional<UserEntity> findUserByEmail(String email);

    void createUser(UserCreateDto userCreateDTO);

    Authentication login(UserLoginRequest request);

    void updateUser(UserUpdateDto userUpdateDto);

}
