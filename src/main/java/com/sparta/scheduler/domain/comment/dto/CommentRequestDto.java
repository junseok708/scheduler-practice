package com.sparta.scheduler.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    @NotEmpty(message = "올바르지 못한 댓글입니다, 댓글을 입력했는지 확인해주세요")
    private String content;

}
