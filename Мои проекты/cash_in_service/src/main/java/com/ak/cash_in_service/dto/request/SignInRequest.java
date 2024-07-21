package com.ak.cash_in_service.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Abubakir Dev
 */
@Getter @Setter
@Builder
public class SignInRequest {
    private String email;
    private String password;
}
