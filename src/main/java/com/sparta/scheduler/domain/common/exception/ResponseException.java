package com.sparta.scheduler.domain.common.exception;

import lombok.Getter;

@Getter
public class ResponseException extends RuntimeException {

    private final ResponseCode responseCode;
    private final String message;

    public ResponseException(ResponseCode responseCode) {
        this.responseCode = responseCode;
        this.message = responseCode.getMessage();
    }

    public ResponseException(ResponseCode responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

}
