package com.ak.cash_in_service.controller;

import com.ak.cash_in_service.dto.request.SignInRequest;
import com.ak.cash_in_service.dto.request.UserRequest;
import com.ak.cash_in_service.dto.response.AuthResponse;
import com.ak.cash_in_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abubakir Dev
 */
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class Login {

    private final UserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> signIn(@RequestBody SignInRequest user){
        return ResponseEntity.ok(userService.signIn(user));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signUp(@RequestBody UserRequest user){
        return ResponseEntity.ok(userService.signUp(user));
    }
}
