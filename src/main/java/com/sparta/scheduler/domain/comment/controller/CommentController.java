package com.sparta.scheduler.domain.comment.controller;

import com.sparta.scheduler.domain.comment.dto.CommentRequestDto;
import com.sparta.scheduler.domain.comment.dto.CommentResponseDto;
import com.sparta.scheduler.domain.comment.service.CommentService;
import com.sparta.scheduler.domain.common.exception.ResponseException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler/userId={userId}/taskId={taskId}/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long userId,
            @PathVariable Long taskId,
            @RequestBody @Valid CommentRequestDto commentRequestDto) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(commentService.createComment(userId, taskId, commentRequestDto));
    }

    @PutMapping("={commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @RequestBody CommentRequestDto commentReq,
            @PathVariable Long userId,
            @PathVariable Long taskId,
            @PathVariable Long commentId) throws ResponseException {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(commentService.updateComment(commentReq, userId, taskId, commentId));
    }

    @DeleteMapping("={commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long taskId,
            @PathVariable Long userId,
            @PathVariable Long commentId) throws ResponseException {
        commentService.deleteComment(taskId, userId, commentId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
