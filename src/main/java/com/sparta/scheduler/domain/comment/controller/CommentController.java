package com.sparta.scheduler.domain.comment.controller;

import com.sparta.scheduler.domain.comment.dto.CommentRequestDto;
import com.sparta.scheduler.domain.comment.dto.CommentResponseDto;
import com.sparta.scheduler.domain.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/scheduler/userId={userId}/taskId={taskId}/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long taskId,
            @PathVariable Long userId,
            @RequestBody @Valid CommentRequestDto commentRequestDto
    ) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(commentService.createComment(taskId, userId, commentRequestDto));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }

    @PutMapping("={commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @RequestBody CommentRequestDto commentReq,
            @PathVariable Long userId,
            @PathVariable Long taskId,
            @PathVariable Long commentId
    ) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(commentService.updateComment(commentReq, userId, taskId, commentId));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .build();
        }


    }

    @DeleteMapping("={commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long taskId,
            @PathVariable Long userId,
            @PathVariable Long commentId
    ) {
        commentService.deleteComment(taskId, userId, commentId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}
