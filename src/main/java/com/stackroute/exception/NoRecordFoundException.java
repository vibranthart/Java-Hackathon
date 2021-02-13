package com.stackroute.exception;

public class NoRecordFoundException extends Exception {

    public NoRecordFoundException() {
        super("No Records Found in file");
    }
}
