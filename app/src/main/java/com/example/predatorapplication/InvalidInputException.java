package com.example.predatorapplication;

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String error_data){
        super(error_data);
    }
}