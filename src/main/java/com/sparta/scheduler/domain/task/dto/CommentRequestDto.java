package com.sparta.scheduler.domain.task.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentRequestDto {
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long taskId;
}
