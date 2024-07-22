package com.example.predatorapplication;

public class CustomException extends Exception {
    public CustomException(String error_data) {
        super(error_data);
    }
}
