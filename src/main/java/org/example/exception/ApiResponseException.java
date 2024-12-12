package org.example.exception;

public class ApiResponseException extends Exception {
    public ApiResponseException(String message){
        super(message);
    }
}
