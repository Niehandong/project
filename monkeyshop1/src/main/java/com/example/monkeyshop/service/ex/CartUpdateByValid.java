package com.example.monkeyshop.service.ex;

public class CartUpdateByValid extends ServiceException{

    public CartUpdateByValid() {
        super();
    }

    public CartUpdateByValid(String message) {
        super(message);
    }

    public CartUpdateByValid(String message, Throwable cause) {
        super(message, cause);
    }

    public CartUpdateByValid(Throwable cause) {
        super(cause);
    }

    protected CartUpdateByValid(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
