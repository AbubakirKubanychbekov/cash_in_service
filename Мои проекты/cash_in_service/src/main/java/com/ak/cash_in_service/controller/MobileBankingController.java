package com.ak.cash_in_service.controller;

import com.ak.cash_in_service.dto.request.SendBalanceByPhoneNumber;
import com.ak.cash_in_service.dto.response.MessageResponse;
import com.ak.cash_in_service.services.MessageService;
import com.ak.cash_in_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Abubakir Dev
 */
@RestController
@RequestMapping("/mobile-banking")
@RequiredArgsConstructor
public class MobileBankingController {

    private final MessageService messageService;
    private final UserService userService;

    @PostMapping(value = "/sendBalanceByPhoneNumber/{phoneNumber}", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<MessageResponse> transfer(@PathVariable String phoneNumber,
                                                                    @RequestBody SendBalanceByPhoneNumber send) {
        return userService.transfer(phoneNumber,send);
    }
}
