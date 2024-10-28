package com.sparta.scheduler.domain.comment.entity;

import com.sparta.scheduler.domain.comment.dto.CommentRequestDto;
import com.sparta.scheduler.domain.comment.dto.CommentResponseDto;
import com.sparta.scheduler.domain.common.timestamp.Timestamped;
import com.sparta.scheduler.domain.task.entity.Task;
import com.sparta.scheduler.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public void init(
            CommentRequestDto taskRequestDto,
            Task task,
            User user) {
        this.user = user;
        this.content = taskRequestDto.getContent();
        this.task = task;

    }

    public CommentResponseDto to() {
        return new CommentResponseDto(
                id,
                user.getId(),
                content,
                task.getId(),
                getCreatedAt(),
                getUpdatedAt()
        );
    }

    public void updateDate(
            CommentRequestDto req,
            Task task) {
        this.content = req.getContent();
    }
}
