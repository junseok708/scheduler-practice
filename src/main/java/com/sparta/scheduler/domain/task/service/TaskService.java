package com.sparta.scheduler.domain.task.service;

import com.sparta.scheduler.domain.task.dto.TaskRequestDto;
import com.sparta.scheduler.domain.task.dto.TaskResponseDto;

import com.sparta.scheduler.domain.task.entity.Task;
import com.sparta.scheduler.domain.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;


    public Page<Task> findAllPaging(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public TaskResponseDto createTask(TaskRequestDto requestDto) {
        Task task = repository.save(Task.from(requestDto));
        return task.to();
    }

    public List<TaskResponseDto> getTaskList() {
        return repository.findAll().stream().map(TaskResponseDto::new).toList();
    }


    public TaskResponseDto getTask(Long id) {
        Task task = findByTask(id);
        return task.to();
    }

    public void updateTask(Long id, TaskRequestDto requestDto) {
        Task task = findByTask(id);
        task.init(requestDto);
        repository.saveAndFlush(task);
    }

    public void deleteTask(Long id) {
        findByTask(id);
        repository.deleteById(id);
    }

    private Task findByTask(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("해당 id를 찾을 수 없습니다"));
    }


}
