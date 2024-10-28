package com.sparta.scheduler.domain.comment.dto;

import com.sparta.scheduler.domain.task.entity.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    private Long userId;
    private String content;
    private Long taskId;
}
