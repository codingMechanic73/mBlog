package com.example.exceptions;

public class UserNameExists extends Exception{
    public UserNameExists(String message) {
        super(message);
    }
}
