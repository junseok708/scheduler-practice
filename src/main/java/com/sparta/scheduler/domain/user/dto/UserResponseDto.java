package com.sparta.scheduler.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String email;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
