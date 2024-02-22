package com.example.tryout.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
