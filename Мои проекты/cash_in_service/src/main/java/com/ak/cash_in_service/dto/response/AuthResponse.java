package com.ak.cash_in_service.dto.response;

import com.ak.cash_in_service.enums.Role;
import lombok.Builder;

/**
 * @author Abubakir Dev
 */

@Builder
public class AuthResponse {
    private String token;
    private String email;
    private Role role;
}
