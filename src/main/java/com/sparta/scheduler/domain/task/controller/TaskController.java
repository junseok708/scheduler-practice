package com.sparta.scheduler.domain.task.controller;

import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import com.sparta.scheduler.domain.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler/{userId}")
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<TaskResponseDto> createTask(
            @RequestBody TaskRequestDto req,
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

    @GetMapping("/{id}")
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

    @GetMapping("/list")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks(
            @PathVariable Long userId,
            @PageableDefault(size = 10)
            Pageable pageable) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.getAllTask(userId, pageable).getContent());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(
            @PathVariable Long id,
            @PathVariable Long userId,
            @RequestBody TaskRequestDto req) {
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

    @DeleteMapping("/{id}")
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