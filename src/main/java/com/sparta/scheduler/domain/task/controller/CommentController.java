package com.sparta.scheduler.domain.task.controller;

import com.sparta.scheduler.domain.task.dto.CommentRequestDto;
import com.sparta.scheduler.domain.task.dto.CommentResponseDto;
import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import com.sparta.scheduler.domain.task.service.CommentService;
import com.sparta.scheduler.domain.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/Comment")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(requestDto);
    }

    @GetMapping("/Comment")
    public List<CommentResponseDto> getTasksList() {
        return commentService.getCommentList();
    }

    @GetMapping("/Comment/{id}")
    public CommentResponseDto getcommentList(@PathVariable Long id) {
        return commentService.getComment(id);
    }

    @PutMapping("/Comment/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.updateTask(id, requestDto);
    }

    @DeleteMapping("/Comment/{id}")
    public void deleteTask(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
