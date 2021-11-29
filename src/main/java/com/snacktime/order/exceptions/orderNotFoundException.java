package com.snacktime.order.exceptions;

public class orderNotFoundException extends RuntimeException{
    public orderNotFoundException(String message){
        super(message);
    }
}
