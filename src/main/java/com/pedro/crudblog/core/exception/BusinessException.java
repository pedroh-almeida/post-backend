package com.pedro.crudblog.core.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String mensage) {
        super(mensage);
    }

    public static void throwMensage(String mensage) {
        throw new BusinessException(mensage);
    }

}
