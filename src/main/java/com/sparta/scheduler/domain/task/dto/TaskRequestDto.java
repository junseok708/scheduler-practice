package com.sparta.scheduler.domain.task.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaskRequestDto {

    @NotEmpty(message = "올바르지 않는 제목입니다, 제목을 입력했는지 확인하세요")
    private String title;
    @NotEmpty(message = "올바르지 않는 일정입니다, 일정을 입력했는지 확인하세요")
    private String content;

}
