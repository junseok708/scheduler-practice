package com.sparta.scheduler.domain.task.dto;

import com.sparta.scheduler.domain.task.entity.Comment;
import com.sparta.scheduler.domain.task.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Comment> comments;

    public TaskResponseDto(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.content = task.getContent();
        this.userName = task.getUserName();
        this.createdAt = task.getCreatedAt();
        this.updatedAt = task.getUpdatedAt();
        this.comments = task.getComments();
    }

}
