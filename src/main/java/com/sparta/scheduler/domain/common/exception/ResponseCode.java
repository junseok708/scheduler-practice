package com.sparta.scheduler.domain.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {


    //성공 에러 코드

    //리턴 에러 코드


    //기타 에러 코드
    BAD_INPUT(HttpStatus.BAD_REQUEST, "잘못된 값 입력"),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류");

    private final HttpStatus httpStatus;
    private final String message;


}
