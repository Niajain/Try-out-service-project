package com.example.tryout.exception;

public class SellerNotFoundException extends RuntimeException{
    public SellerNotFoundException(String message)
    {
        super(message);
    }
}
