package com.sparta.scheduler.domain.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {


    NOT_FOUND(HttpStatus.NOT_FOUND,"입력한 값이 없습니다, 다시 입력해주세요"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 값 입력"),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류");

    private final HttpStatus httpStatus;
    private final String message;


}
