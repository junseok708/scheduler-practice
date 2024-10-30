package com.sparta.scheduler.domain.task.repository;

import com.sparta.scheduler.domain.task.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    default Task findByTask(Long id) {
        return findById(id).orElseThrow(() ->
                new IllegalAccessError("존재하지 않는 회원입니다"));
    }
    List<Task> findAllByUserId(Long userId);

    Page<Task> findAllByUserId(Long userId, Pageable pageable);

    void deleteByUserId(Long userId);
}
