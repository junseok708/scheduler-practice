package com.sparta.scheduler.domain.task.entity;

import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String title;
    @Column()
    private String content;
    @Column
    private String userName;


    @OneToMany(mappedBy = "task",cascade = CascadeType.PERSIST)
    private List<Comment> comments = new ArrayList<>();


    public static Task from(TaskRequestDto requestDto) {
        Task task = new Task();
        task.init(requestDto);
        return task;
    }

    public void init(TaskRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.userName = requestDto.getUserName();
        setCreatedAt(requestDto.getCreatedAt());
        setUpdatedAt(requestDto.getUpdatedAt());
        setComments(requestDto.getComments());
    }

    public TaskResponseDto to() {
        return new TaskResponseDto(
                this.id,
                this.title,
                this.content,
                this.userName,
                this.getCreatedAt(),
                this.getUpdatedAt(),
                this.getComments()
        );
    }


}
