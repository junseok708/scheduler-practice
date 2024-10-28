package com.sparta.scheduler.domain.task.entity;

import com.sparta.scheduler.domain.comment.entity.Comment;
import com.sparta.scheduler.domain.common.timestamp.Timestamped;
import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import com.sparta.scheduler.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Task extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String title;

    @Column
    private String content;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "task_user",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();

    public void init(TaskRequestDto taskRequestDto, User user) {
        this.user = user;
        this.title = taskRequestDto.getTitle();
        this.content = taskRequestDto.getContent();
    }

    public TaskResponseDto to() {
        return new TaskResponseDto(
                id,
                user.getId(),
                title,
                content,
                comments.stream().map(Comment::to).toList(),
                getCreatedAt(),
                getUpdatedAt()
        );
    }

    public void updateDate(TaskRequestDto req) {
        this.title = req.getTitle();
        this.content = req.getContent();
    }
}
