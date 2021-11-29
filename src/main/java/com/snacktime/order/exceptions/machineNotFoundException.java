package com.snacktime.order.exceptions;

public class machineNotFoundException extends RuntimeException{
    public machineNotFoundException(String message){
        super(message);
    }
}
