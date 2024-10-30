package com.sparta.scheduler.domain.comment.service;

import com.sparta.scheduler.domain.comment.dto.CommentRequestDto;
import com.sparta.scheduler.domain.comment.dto.CommentResponseDto;
import com.sparta.scheduler.domain.comment.entity.Comment;
import com.sparta.scheduler.domain.comment.repository.CommentRepository;
import com.sparta.scheduler.domain.task.entity.Task;
import com.sparta.scheduler.domain.task.repository.TaskRepository;
import com.sparta.scheduler.domain.user.entity.User;
import com.sparta.scheduler.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRep;
    private final TaskRepository taskRep;
    private final UserRepository userRep;


    public CommentResponseDto createComment(
            Long taskId, Long userId, CommentRequestDto commentRequestDto
    ) {
        Task task = taskRep.findByTask(taskId);
        User user = userRep.findByUser(userId);
        Comment comment = new Comment();
        comment.init(commentRequestDto, task, user);
        commentRep.save(comment);
        return comment.to();
    }

    @Transactional
    public CommentResponseDto updateComment(
            CommentRequestDto commentReq,
            Long userId, Long taskId, Long commentId
    ) {
        userRep.findByUser(userId);
        Task task = taskRep.findByTask(taskId);
        Comment comment = commentRep.findByComment(commentId);
        comment.updateDate(commentReq, task);
        return comment.to();
    }

    @Transactional
    public void deleteComment(
            Long taskId, Long userId, Long commentId
    ) {
        taskRep.findByTask(taskId);
        userRep.findByUser(userId);
        Comment comment = commentRep.findByComment(commentId);
        commentRep.delete(comment);
    }
}
