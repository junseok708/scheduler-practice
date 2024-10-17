package com.sparta.scheduler.domain.task.dto;

import com.sparta.scheduler.domain.task.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long taskId;


    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userName = comment.getUserName();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.taskId = comment.getTask().getId();

    }
}
