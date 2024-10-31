package com.sparta.scheduler.domain.common.exception;

public abstract class ExceptionMethod {
    public static <T> void isNull(T entity) {
        if (entity == null) {
            throw new ResponseException(ResponseCode.NOT_FOUND);
        }
    }
}
