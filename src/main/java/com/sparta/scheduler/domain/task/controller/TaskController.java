package com.sparta.scheduler.domain.task.controller;

import com.sparta.scheduler.domain.common.exception.ResponseException;
import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import com.sparta.scheduler.domain.task.dto.TaskResponsePage;
import com.sparta.scheduler.domain.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler/userId={userId}")
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskResponseDto> createTask(
            @RequestBody @Valid TaskRequestDto req,
            @PathVariable Long userId) throws ResponseException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.createTask(req, userId));

    }

    @GetMapping("/taskId={id}")
    public ResponseEntity<TaskResponseDto> getOneTask(
            @PathVariable Long id,
            @PathVariable Long userId) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.getOneTask(id, userId));

    }

    @GetMapping("/taskPage")
    public ResponseEntity<TaskResponsePage> getTasksPage(
            @PathVariable Long userId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "updatedAt") String criteria) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.getTasksWithPaging(userId, page, size, criteria));

    }

    @GetMapping("/taskList")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(
            @PathVariable Long userId) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.getAllTask(userId));

    }

    @PutMapping("/taskId={id}")
    public ResponseEntity<TaskResponseDto> updateTask(
            @PathVariable Long id,
            @PathVariable Long userId,
            @RequestBody @Valid TaskRequestDto req) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.updateTask(id, userId, req));


    }

    @DeleteMapping("/taskId={id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id,
            @PathVariable Long userId) throws ResponseException {
        taskService.deleteTask(id, userId);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();

    }

}
