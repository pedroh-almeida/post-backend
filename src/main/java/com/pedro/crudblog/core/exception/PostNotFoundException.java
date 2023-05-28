package com.pedro.crudblog.core.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(String mensage) {
        super(mensage);
    }

    public static void throwMensage(String mensage) {
        throw new PostNotFoundException(mensage);
    }

}
