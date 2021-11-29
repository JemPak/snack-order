package com.snacktime.order.exceptions;

public class personNotFoundException extends RuntimeException{
    public personNotFoundException(String message){
        super(message);
    }
}
