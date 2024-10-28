package com.sparta.scheduler.domain.comment.repository;

import com.sparta.scheduler.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByComment(Long id) {
        return findById(id).orElseThrow(()
                -> new IllegalAccessError("존재하지 않는 회원입니다"));
    }


}
