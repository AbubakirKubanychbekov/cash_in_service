package com.ak.cash_in_service.exceptions;

/**
 * @author Abubakir Dev
 */

public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String message){
        super(message);
    }
}
