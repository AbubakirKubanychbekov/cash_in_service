package com.ak.cash_in_service.exceptions;

/**
 * @author Abubakir Dev
 */
public class BadCredentialException extends RuntimeException{
    public BadCredentialException(String message){
        super(message);
    }
}
