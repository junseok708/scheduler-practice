package com.sparta.scheduler.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    @NotBlank(message = "올바른 유저가 아닙니다")
    private Long userId;

    @NotEmpty(message = "올바르지 못한 댓글입니다, 댓글을 입력했는지 확인해주세요")
    private String content;

    @NotBlank(message = "올바른 일정이 아닙니다")
    private Long taskId;
}
