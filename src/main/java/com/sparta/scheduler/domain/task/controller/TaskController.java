package com.sparta.scheduler.domain.task.controller;

import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import com.sparta.scheduler.domain.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;


    @PostMapping
    public TaskResponseDto createTask(@RequestBody TaskRequestDto requestDto) {
        return taskService.createTask(requestDto);
    }

    @GetMapping()
    public List<TaskResponseDto> getTasksList() {
        return taskService.getTaskList();
    }



    @GetMapping("/{id}")
    public TaskResponseDto getTasksList(@PathVariable Long id) {
        return taskService.getTask(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody TaskRequestDto requestDto) {
        taskService.updateTask(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }



}
