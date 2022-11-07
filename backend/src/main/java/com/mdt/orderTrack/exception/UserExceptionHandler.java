package com.mdt.orderTrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<?> invalidUsernameOrPassword(UserLoginException userLoginException){
        return getErrorResponse(userLoginException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RegisterException.class)
    public ResponseEntity<?> uniqueUsernameOrEmail(RegisterException registerException){
        return getErrorResponse(registerException.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> userNotFound(UserNotFound userNotFound){
        return getErrorResponse(userNotFound.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> getErrorResponse(String message,HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
