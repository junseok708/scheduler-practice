package com.sparta.scheduler.domain.task.dto;

import com.sparta.scheduler.domain.task.entity.Task;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class TaskResponsePage {

    private List<TaskResponseDto> taskList;
    private int totalPages;
    private int totalElements;

    public TaskResponsePage(Page<Task> page) {
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getNumberOfElements();
        this.taskList = page
                .stream()
                .map(Task::to)
                .toList();
    }
}
