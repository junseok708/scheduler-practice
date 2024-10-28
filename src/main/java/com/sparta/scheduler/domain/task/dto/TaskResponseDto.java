package com.sparta.scheduler.domain.task.dto;

import com.sparta.scheduler.domain.comment.dto.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private List<CommentResponseDto> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
