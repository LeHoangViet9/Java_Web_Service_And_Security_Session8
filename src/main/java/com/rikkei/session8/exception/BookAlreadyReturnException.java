package com.rikkei.session8.exception;

public class BookAlreadyReturnException extends RuntimeException {
    public BookAlreadyReturnException(String message) {
        super(message);
    }
}
