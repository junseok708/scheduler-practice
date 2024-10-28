package com.sparta.scheduler.domain.comment.dto;

import com.sparta.scheduler.domain.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private Long userId;
    private String content;
    private Long taskId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
