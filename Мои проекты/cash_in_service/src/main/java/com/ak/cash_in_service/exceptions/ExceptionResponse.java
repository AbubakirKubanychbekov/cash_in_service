package com.ak.cash_in_service.exceptions;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * @author Abubakir Dev
 */
@Builder
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
    private String className;
}
