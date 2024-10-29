package com.sparta.scheduler.domain.task.controller;

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
            @PathVariable Long userId
    ) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(taskService.createTask(req, userId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }
    }

    @GetMapping("/taskId={id}")
    public ResponseEntity<TaskResponseDto> getOneTask(
            @PathVariable Long id,
            @PathVariable Long userId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.getOneTask(id, userId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @GetMapping("/taskPage")
    public ResponseEntity<TaskResponsePage> getTasksPage(
            @PathVariable Long userId,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "updatedAt") String criteria) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.getTasksWithPaging(userId, page, size,criteria));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @GetMapping("/taskList")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(@PathVariable Long userId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.getAllTask(userId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @PutMapping("/taskId={id}")
    public ResponseEntity<TaskResponseDto> updateTask(
            @PathVariable Long id,
            @PathVariable Long userId,
            @RequestBody @Valid TaskRequestDto req) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.updateTask(id, userId, req));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }

    }

    @DeleteMapping("/taskId={id}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id,
            @PathVariable Long userId) {
        taskService.deleteTask(id, userId);
        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }
    }

}
