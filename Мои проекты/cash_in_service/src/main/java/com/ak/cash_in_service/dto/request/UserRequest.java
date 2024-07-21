package com.ak.cash_in_service.dto.request;

import com.ak.cash_in_service.enums.Currency;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Abubakir Dev
 */
@Builder
@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Double balance;
    private Currency currency;
}
