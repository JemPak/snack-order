package com.snacktime.order.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class orderNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(orderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userEmailNotFoundAdvice(orderNotFoundException ex){
        return ex.getMessage();
    }
}
