package com.mdt.orderTrack.controller;

import com.mdt.orderTrack.dto.user.UserLoginDto;
import com.mdt.orderTrack.dto.user.UserRegisterDto;
import com.mdt.orderTrack.dto.user.UserResponseDto;
import com.mdt.orderTrack.entity.User;
import com.mdt.orderTrack.service.AuthService;
import com.mdt.orderTrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("register")
    public void  register(@RequestBody @Valid UserRegisterDto userRegisterDto){
         authService.insert(userRegisterDto);
    }

    @PostMapping("login")
    public UserResponseDto login(@RequestBody UserLoginDto userLoginDto){
        return authService.login(userLoginDto);
    }
}
