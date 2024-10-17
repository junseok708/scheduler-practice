package com.sparta.scheduler.domain.task.entity;

import com.sparta.scheduler.domain.task.dto.CommentRequestDto;
import com.sparta.scheduler.domain.task.dto.CommentResponseDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "comment")
public class Comment extends Timestamped  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String content;
    @Column
    private String userName;


    @ManyToOne
    @JoinColumn(name="taskId")
    private Task task;

    public static Comment from(CommentRequestDto requestDto) {
        Comment comment = new Comment();
        comment.init(requestDto);
        return comment;
    }

    public void init(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
        this.userName = requestDto.getUserName();
    }

    public CommentResponseDto to() {
        return new CommentResponseDto(
                this.id,
                this.content,
                this.userName,
                this.getCreatedAt(),
                this.getUpdatedAt(),
                this.task.getId()

        );
    }

}
