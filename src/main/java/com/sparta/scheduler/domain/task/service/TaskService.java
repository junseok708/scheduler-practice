package com.sparta.scheduler.domain.task.service;

import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;
import com.sparta.scheduler.domain.task.entity.Task;
import com.sparta.scheduler.domain.task.repository.TaskRepository;
import com.sparta.scheduler.domain.user.entity.User;
import com.sparta.scheduler.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRep;
    private final UserRepository userRep;

    @Transactional
    public TaskResponseDto createTask(
            TaskRequestDto TaskReq, Long userId) {
        User user = userRep.findByUser(userId);
        Task task = new Task();
        task.init(TaskReq, user);
        taskRep.save(task);
        return task.to();
    }


    public TaskResponseDto getOneTask(Long id, Long userId) {
        User user = userRep.findByUser(userId);
        Task task = taskRep.findByTask(id);
        return task.to();
    }


    public Page<TaskResponseDto> getAllTask(
            Long userId, Pageable pageable
    ) {
        User user = userRep.findByUser(userId);
        Page<Task> tasks = taskRep.findAllByUserId(userId, pageable);
        return tasks
                .map(Task::to);
    }

    @Transactional
    public TaskResponseDto updateTask(
            Long id, Long userId, TaskRequestDto req
    ) {
        User user = userRep.findByUser(userId);
        Task task = taskRep.findByTask(id);
        task.init(req, user);
        task.updateDate(req);
        return task.to();
    }

    @Transactional
    public void deleteTask(Long id, Long userId) {
        User user = userRep.findByUser(userId);
        Task task = taskRep.findByTask(id);
        taskRep.deleteById(id);
    }
}
