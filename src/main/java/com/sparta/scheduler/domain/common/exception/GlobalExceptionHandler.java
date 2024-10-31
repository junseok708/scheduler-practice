package com.sparta.scheduler.domain.common.exception;

import com.sparta.scheduler.domain.common.dto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseException.class)
    public ResponseEntity<ResponseStatusDto> BaseExceotion(ResponseException ex) {
        return ResponseEntity
                .status(ex.getResponseCode().getHttpStatus())
                .body(new ResponseStatusDto(ex.getResponseCode()));
    }

}
