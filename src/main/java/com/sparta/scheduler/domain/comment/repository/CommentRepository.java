package com.sparta.scheduler.domain.comment.repository;

import com.sparta.scheduler.domain.comment.entity.Comment;
import com.sparta.scheduler.domain.common.exception.ResponseCode;
import com.sparta.scheduler.domain.common.exception.ResponseException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByComment(Long id) {
        return findById(id).orElseThrow(()
                -> new ResponseException(ResponseCode.BAD_REQUEST,"존재하지 않는 회원입니다"));
    }

    void deleteByUserId(Long userId);

    void deleteByTaskId(Long taskId);
}
