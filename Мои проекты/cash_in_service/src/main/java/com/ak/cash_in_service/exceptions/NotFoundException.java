package com.ak.cash_in_service.exceptions;

import lombok.Getter;

/**
 * @author Abubakir Dev
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
