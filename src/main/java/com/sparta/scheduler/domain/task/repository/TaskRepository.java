package com.sparta.scheduler.domain.task.repository;

import com.sparta.scheduler.domain.task.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByTaskOrderByIdDesc(Long id, Pageable pageable);

}
