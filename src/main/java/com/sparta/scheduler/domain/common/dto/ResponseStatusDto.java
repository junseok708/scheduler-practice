package com.sparta.scheduler.domain.common.dto;

import com.sparta.scheduler.domain.common.exception.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseStatusDto {

    private final int state;
    private final String message;

    public ResponseStatusDto(ResponseCode responseCode) {
        state = responseCode.getHttpStatus().value();
        message = responseCode.getMessage();
    }

    public ResponseStatusDto(ResponseCode responseCode, String message) {
        state = responseCode.getHttpStatus().value();
        this.message = responseCode.getMessage() + " : " + message;
    }
}
