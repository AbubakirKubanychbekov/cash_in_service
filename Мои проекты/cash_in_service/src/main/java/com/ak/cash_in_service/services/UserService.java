package com.ak.cash_in_service.services;

import com.ak.cash_in_service.dto.request.SendBalanceByPhoneNumber;
import com.ak.cash_in_service.dto.request.SignInRequest;
import com.ak.cash_in_service.dto.request.UserRequest;
import com.ak.cash_in_service.dto.response.AuthResponse;
import com.ak.cash_in_service.dto.response.MessageResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author Abubakir Dev
 */
public interface UserService {
    ResponseEntity<MessageResponse> transfer(String phoneNumber, SendBalanceByPhoneNumber send);

    AuthResponse signIn(SignInRequest user);

    AuthResponse signUp(UserRequest user);
}
