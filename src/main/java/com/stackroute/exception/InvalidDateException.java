package com.stackroute.exception;

public class InvalidDateException extends Exception {
    public InvalidDateException() {
        super("Date is invalid");
    }
}
