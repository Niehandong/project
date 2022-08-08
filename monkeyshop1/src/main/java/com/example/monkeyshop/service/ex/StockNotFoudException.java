package com.example.monkeyshop.service.ex;

public class StockNotFoudException extends RuntimeException{
    public StockNotFoudException() {
        super();
    }

    public StockNotFoudException(String message) {
        super(message);
    }

    public StockNotFoudException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockNotFoudException(Throwable cause) {
        super(cause);
    }

    protected StockNotFoudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
