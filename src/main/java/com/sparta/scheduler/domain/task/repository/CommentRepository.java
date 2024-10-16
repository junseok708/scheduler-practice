package com.sparta.scheduler.domain.task.repository;

import com.sparta.scheduler.domain.task.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {

}
