package com.shop.controller;

import com.shop.domain.dto.request.UserLoginRequest;
import com.shop.domain.dto.user.UserCreateDto;
import com.shop.domain.dto.user.UserUpdateDto;
import com.shop.service.TokenService;
import com.shop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

//    @PostMapping("/token")
//    public String generateToken(Authentication auth){
//        var token = tokenService.generateToken(auth);
//        return "Bearer ".concat(token);
//    }

    @PostMapping("/register")
    public ResponseEntity<String> registrationRoleUser(@Valid @RequestBody UserCreateDto userToCreate) {
        userService.createUser(userToCreate);
        return ResponseEntity.ok("User created successfully!");
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody UserLoginRequest req) {
        var authentication = userService.login(req);
        return tokenService.generateToken(authentication);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserUpdateDto userToUpdate) {
        userService.updateUser(userToUpdate);
        return ResponseEntity.ok("User updated successfully!");
    }


}
