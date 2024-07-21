package com.ak.cash_in_service.services.impl;

import com.ak.cash_in_service.config.JwtService;
import com.ak.cash_in_service.dto.request.SendBalanceByPhoneNumber;
import com.ak.cash_in_service.dto.request.SignInRequest;
import com.ak.cash_in_service.dto.request.UserRequest;
import com.ak.cash_in_service.dto.response.AuthResponse;
import com.ak.cash_in_service.dto.response.MessageResponse;
import com.ak.cash_in_service.enums.Role;
import com.ak.cash_in_service.exceptions.AlreadyExistException;
import com.ak.cash_in_service.exceptions.BadCredentialException;
import com.ak.cash_in_service.exceptions.NotFoundException;
import com.ak.cash_in_service.model.Message;
import com.ak.cash_in_service.model.User;
import com.ak.cash_in_service.repository.MessageRepository;
import com.ak.cash_in_service.repository.UserRepository;
import com.ak.cash_in_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



/**
 * @author Abubakir Dev
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public AuthResponse signUp(UserRequest user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new AlreadyExistException("User with email :"
                    + user.getEmail() + " already exists");
        }
        User user1 = new User();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setBalance(user.getBalance());
        user1.setCurrency(user.getCurrency());
        user1.setRole(Role.USER);
        userRepository.save(user1);
        String token = jwtService.generateToken(user1);
        return AuthResponse.builder()
                .email(user1.getEmail())
                .role(user1.getRole())
                .token(token)
                .build();
    }

    @Override
    public AuthResponse signIn(SignInRequest user) {
        User user1 = userRepository.getUserByEmail(user.getEmail()).orElseThrow(() ->
                new NotFoundException(String.format("User with email : %s not found!", user.getEmail())));
        if (!passwordEncoder.matches(user.getPassword(), user1.getPassword())) {
            log.info("Недействительный пароль");
            throw new BadCredentialException("Bad credential password");
        }
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()));
        String token = jwtService.generateToken(user1);
        return AuthResponse.builder()
                .role(user1.getRole())
                .email(user1.getEmail())
                .token(token)
                .build();
    }

    @Override
    public ResponseEntity<MessageResponse> transfer(String phoneNumber, SendBalanceByPhoneNumber send) {
        log.info("1.Здесь работает ");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user1 = userRepository.getUserByEmail(email).orElseThrow(null);
        log.info("2.");
        if (user1 != null) {
            User user = userRepository.findUserByPhoneNumber(phoneNumber).orElseThrow(() ->
                    new NotFoundException("User with phone number " + phoneNumber + " not found"));
            user1.setBalance(user1.getBalance() - user1.getAmount());
            user.setBalance(user.getBalance() + user.getAmount());
            userRepository.save(user1);
            userRepository.save(user);
            log.info("3");
            Message ms = new Message();
            ms.setSenderId(send.getSourceId());
            ms.setPayee(send.getPayee());
            ms.setBody(send.getBody());
            ms.setQid(send.getQid());
            messageRepository.save(ms);
            log.info("4");
        }
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
