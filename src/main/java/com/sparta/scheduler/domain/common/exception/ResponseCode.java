package com.sparta.scheduler.domain.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS_LOGIN(HttpStatus.OK,"유저 생성 완료"),


    //기타 에러 코드
    BAD_INPUT(HttpStatus.BAD_REQUEST, "잘못된 값 입력"),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 오류");

    private final HttpStatus httpStatus;
    private final String message;


}
