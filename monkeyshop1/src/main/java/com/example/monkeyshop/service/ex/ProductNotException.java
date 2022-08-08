package com.example.monkeyshop.service.ex;

public class ProductNotException extends RuntimeException{
    public ProductNotException() {
        super();
    }

    public ProductNotException(String message) {
        super(message);
    }

    public ProductNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotException(Throwable cause) {
        super(cause);
    }

    protected ProductNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
