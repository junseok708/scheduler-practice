package com.sparta.scheduler.domain.task.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TaskRequestDto {
    private String name;
    private String title;
    private String content;


}
