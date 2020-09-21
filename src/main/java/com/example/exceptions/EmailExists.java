package com.example.exceptions;

public class EmailExists extends Exception{
    public EmailExists(String message) {
        super(message);
    }
}
