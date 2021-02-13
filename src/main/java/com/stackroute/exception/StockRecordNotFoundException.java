package com.stackroute.exception;

public class StockRecordNotFoundException extends Exception {
    public StockRecordNotFoundException() {
        super("Matching record not found");
    }
}
