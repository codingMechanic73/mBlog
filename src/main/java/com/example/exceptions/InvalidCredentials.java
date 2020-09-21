package com.example.exceptions;

public class InvalidCredentials extends Exception {

    public InvalidCredentials(String message) {
        super(message);
    }
}
