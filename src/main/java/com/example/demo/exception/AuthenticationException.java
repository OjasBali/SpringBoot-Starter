package com.example.demo.exception;

public class AuthenticationException extends SecurityException {
    public AuthenticationException(String message) {
        super(message);
    }
}
