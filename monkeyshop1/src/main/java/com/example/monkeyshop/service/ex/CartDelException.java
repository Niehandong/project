package com.example.monkeyshop.service.ex;

public class CartDelException extends ServiceException{
    public CartDelException() {
        super();
    }

    public CartDelException(String message) {
        super(message);
    }

    public CartDelException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartDelException(Throwable cause) {
        super(cause);
    }

    protected CartDelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
